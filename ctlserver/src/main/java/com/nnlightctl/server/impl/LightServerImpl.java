package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.LightingMapper;
import com.nnlightctl.jdbcdao.LightDao;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.po.LightingExample;
import com.nnlightctl.request.LightConditionRequest;
import com.nnlightctl.request.LightRequest;
import com.nnlightctl.server.LightServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class LightServerImpl implements LightServer {
    @Autowired
    private LightingMapper lightingMapper;

    @Autowired
    private LightDao lightDao;

    @Override
    public int addOrUpdateLight(LightRequest request) {
        Lighting lighting = new Lighting();
        ReflectCopyUtil.beanSameFieldCopy(request, lighting);
        lighting.setGmtUpdated(new Date());
        if (!StringUtils.isEmpty(request.getDecay())) {
            lighting.setDecay(new BigDecimal(request.getDecay()));
        }
        int ret = -1;
        if (request.getId() != null) {  //修改
            ret = lightingMapper.updateByPrimaryKeySelective(lighting);
        } else {
            lighting.setGmtCreated(new Date());
            ret = lightingMapper.insertSelective(lighting);
        }
        return ret;
    }

    @Override
    public int batchAddLight(LightRequest.BatchLightRequest request) {
        List<LightRequest> lightRequestList = request.getAddLightings();
        for (LightRequest lightRequest : lightRequestList) {
            Lighting lighting = new Lighting();
            ReflectCopyUtil.beanSameFieldCopy(lightRequest, lighting);
            lighting.setGmtCreated(new Date());
            lighting.setGmtUpdated(new Date());
            lightingMapper.insertSelective(lighting);
        }

        return 1;
    }

    @Override
    public int deleteLight(LightConditionRequest request) {
        List<Long> deleteLightIdList = request.getDeleteLightIdList();
        int ret = -1;
        for (Long deleteLightId : deleteLightIdList) {
            ret = lightingMapper.deleteByPrimaryKey(deleteLightId);
        }
        return ret;
    }

    @Override
    public Tuple.TwoTuple<List<Lighting>, Integer> listLighting(LightConditionRequest request) {
        Tuple.TwoTuple<List<Lighting>, Integer> tuple = new Tuple.TwoTuple<>();
        LightingExample lightingExample = new LightingExample();
        LightingExample.Criteria criteria = lightingExample.createCriteria();

        if (request.getNotBe() != null && request.getNotBe() == 1) {
            //搜索不属于任何控制柜的灯具
            criteria.andNnlightctlEleboxIdIsNull();
        } else if (request.getEleboxId() != null) {
            //搜索某控制柜下全部灯具
            criteria.andNnlightctlEleboxIdEqualTo(request.getEleboxId());
        }

        if (request.getProjectId() != null) {
            criteria.andNnlightctlProjectIdEqualTo(request.getProjectId());
        }

        int total = this.lightingMapper.countByExample(lightingExample);
        PageHelper.startPage(request.getPageNumber(), request.getPageSize());
        lightingExample.setOrderByClause("id DESC");
        List<Lighting> lightings = this.lightingMapper.selectByExample(lightingExample);

        tuple.setFirst(lightings);
        tuple.setSecond(total);
        return tuple;
    }

    @Override
    public int updateLightBeElebox(LightConditionRequest request) {
        List<Long> lightIdList = request.getLightIdList();
        for (Long lightId : lightIdList) {
            Lighting lighting = new Lighting();
            lighting.setId(lightId);
            lighting.setNnlightctlEleboxId(request.getBeEleboxId());
            this.lightingMapper.updateByPrimaryKeySelective(lighting);
        }
        return 1;
    }

    @Override
    public Lighting getLighting(Long id) {
        return lightingMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Lighting> getLightByLoopId(Long id) {
        LightingExample lightingExample = new LightingExample();
        lightingExample.createCriteria().andNnlightctlEleboxModelLoopIdEqualTo(id);
        lightingExample.setOrderByClause("id DESC");

        return lightingMapper.selectByExample(lightingExample);
    }

    @Override
    public int updateLightBeEleboxBeLoop(LightConditionRequest request) {
        lightDao.clearLightBeEleboxBeLoop(request.getEleboxId(), request.getModelLoopId());
        List<Long> lightIdList = request.getLightIdList();
        for (Long lightId : lightIdList) {
            Lighting lighting = new Lighting();
            lighting.setId(lightId);
            lighting.setNnlightctlEleboxId(request.getEleboxId());
            lighting.setNnlightctlEleboxModelLoopId(request.getModelLoopId());
            lightingMapper.updateByPrimaryKeySelective(lighting);
        }
        return 1;
    }
}
