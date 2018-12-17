package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.QuartzUtil;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.EleboxMapper;
import com.nnlightctl.dao.LightSignalLogMapper;
import com.nnlightctl.dao.LightingMapper;
import com.nnlightctl.dao.LightingVolEleRecordMapper;
import com.nnlightctl.jdbcdao.EnergyStatisticDao;
import com.nnlightctl.jdbcdao.LightSignalRecordDao;
import com.nnlightctl.po.*;
import com.nnlightctl.request.*;
import com.nnlightctl.server.EnergyStatisticServer;
import com.nnlightctl.vo.CommonEnergyStatisticView;
import com.nnlightctl.vo.GetEleboxEnergyStatisticView;
import com.nnlightctl.vo.ListEleboxEnergyStatisticView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EnergyStatisticServerImpl implements EnergyStatisticServer {

    private static final Logger log = LoggerFactory.getLogger(EnergyStatisticServerImpl.class);

    @Autowired
    private EnergyStatisticDao energyStatisticDao;
    @Autowired
    private EleboxMapper eleboxMapper;
    @Autowired
    private LightingMapper lightingMapper;
    @Autowired
    private LightingVolEleRecordMapper lightingVolEleRecordMapper;
    @Autowired
    private LightSignalLogMapper lightSignalLogMapper;
    @Autowired
    private LightSignalRecordDao lightSignalRecordDao;

    @Override
    public List<EleboxVolEleRecord> listEleboxPower(EleboxPowerRequest eleboxPowerRequest) {
        Long id = eleboxPowerRequest.getEleboxId();
        Elebox elebox = eleboxMapper.selectByPrimaryKey(id);
        if (elebox != null) {
            eleboxPowerRequest.setUid(elebox.getUid());
        }
        return energyStatisticDao.listEleboxPower(eleboxPowerRequest);
    }

    @Override
    public List<LightingVolEleRecord> listLightingVolEleRecord(LightingVolEleRecordRequest lightingVolEleRecordRequest) {
        return energyStatisticDao.listLightingVolEleRecord(lightingVolEleRecordRequest);
    }

    @Override
    public List<CommonEnergyStatisticView> getCommonEnergyStatistic() {
        List<CommonEnergyStatisticView> dateTotal = energyStatisticDao.getCommonEnergyStatisticDate();
        List<CommonEnergyStatisticView> mouthTotal = energyStatisticDao.getCommonEnergyStatisticMouth();
        List<CommonEnergyStatisticView> yearTotal = energyStatisticDao.getCommonEnergyStatisticYear();
        List<CommonEnergyStatisticView> list = new ArrayList<>();
        list.addAll(dateTotal);
        list.addAll(mouthTotal);
        list.addAll(yearTotal);
        return list;
    }

    @Override
    public List<CommonEnergyStatisticView> listEnergyStatisticByDay(int month) {
        return energyStatisticDao.listEnergyStatisticByDay(month);
    }

    @Override
    public List<ListEleboxEnergyStatisticView> listEleboxEnergyStatistic(listEleboxEnergyStatisticRequest request) {
        return energyStatisticDao.listEleboxEnergyStatistic(request);
    }

    @Override
    public List<GetEleboxEnergyStatisticView> getEleboxEnergyStatistic(listEleboxEnergyStatisticRequest request) {
        return energyStatisticDao.getEleboxEnergyStatistic(request);
    }

    @Override
    public List<LightingVolEleRecord> listStatisticLightEnergy(StatisticLightEnergyRequest request) {
        LightingVolEleRecordExample lightingVolEleRecordExample = new LightingVolEleRecordExample();
        List<LightingVolEleRecord> lightingVolEleRecordList = new ArrayList<>();
        LightingExample lightingExample = new LightingExample();
        lightingExample.createCriteria().andLightingCodeEqualTo(request.getLightingCode());
        List<Lighting> lightingList = lightingMapper.selectByExample(lightingExample);
        if (!lightingList.isEmpty()) {
            LightingVolEleRecordExample.Criteria criteria = lightingVolEleRecordExample.createCriteria();
            criteria.andUidEqualTo(lightingList.get(0).getUid());
            if (request.getEndDate() != null) {
                criteria.andRecordDatetimeLessThanOrEqualTo(request.getEndDate());
            }
            if (request.getStartDate() != null) {
                criteria.andRecordDatetimeGreaterThanOrEqualTo(request.getStartDate());
            }
            lightingVolEleRecordExample.setOrderByClause(" id Desc");
            lightingVolEleRecordList = lightingVolEleRecordMapper.selectByExample(lightingVolEleRecordExample);
        }

        return lightingVolEleRecordList;
    }

    @Override
    public Tuple.TwoTuple<List<LightSignalLog>, Integer> listLightSignalLog(SignalLogRequest request) {
        Tuple.TwoTuple<List<LightSignalLog>, Integer> tuple = new Tuple.TwoTuple<>();
        LightSignalLogExample lightSignalLogExample = new LightSignalLogExample();
        lightSignalLogExample.setOrderByClause("id DESC");
        LightSignalLogExample.Criteria criteria = lightSignalLogExample.createCriteria();
        if (!StringUtils.isEmpty(request.getUuid())) {
            criteria.andUidLike("%" + request.getUuid() + "%");
        }
        if (!StringUtils.isEmpty(request.getEndDate())) {
            criteria.andSignalLogDateLessThanOrEqualTo(request.getEndDate());
        }
        if (!StringUtils.isEmpty(request.getStartDate())) {
            criteria.andSignalLogDateGreaterThanOrEqualTo(request.getStartDate());
        }
        int total = lightSignalLogMapper.countByExample(lightSignalLogExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());
        List<LightSignalLog> list = lightSignalLogMapper.selectByExample(lightSignalLogExample);
        tuple.setFirst(list);

        return tuple;
    }

    @PostConstruct
    public void startLightOffLineScan() {
        QuartzUtil.addJob(() -> {
            try {
                List<Lighting> lightingList = lightingMapper.selectByExample(new LightingExample());
                for (Lighting lighting : lightingList) {
                    try {
                        if (lighting.getFaultTag() != null && lighting.getFaultTag() == (byte) 2) {
                            //添加掉线记录
                            LightSignalLog lightSignalLog = new LightSignalLog();

                            ReflectCopyUtil.beanSameFieldCopy(lighting, lightSignalLog);
                            lightSignalLog.setGmtCreated(new Date());
                            lightSignalLog.setGmtUpdated(new Date());
                            lightSignalLog.setSignalLogDate(new Date());
                            lightSignalLog.setSignalIntensity(new BigDecimal("0"));
                            lightSignalLog.setSignalLevel((byte) 0);
                            lightSignalLog.setUnit("db");
                            lightSignalLog.setOnlineState((byte) 0);

//                            lightSignalLogMapper.insertSelective(lightSignalLog);
                            lightSignalRecordDao.addLightSignalRecord(lightSignalLog);
                        }
                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }

                    lighting.setFaultTag((byte) 2);

                    lightingMapper.updateByPrimaryKeySelective(lighting);
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }, 60, null);
    }
}
