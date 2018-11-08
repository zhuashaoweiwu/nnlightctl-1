package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.LightingGroupMapper;
import com.nnlightctl.dao.LightingMapper;
import com.nnlightctl.jdbcdao.LightingGroupMapDao;
import com.nnlightctl.jdbcdao.LightingGroupMapGroupDao;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.po.LightingExample;
import com.nnlightctl.po.LightingGroup;
import com.nnlightctl.po.LightingGroupExample;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.LightGroupConditionRequest;
import com.nnlightctl.request.LightGroupRequest;
import com.nnlightctl.server.LightGroupServer;
import com.nnlightctl.vo.LightGroupView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LightGroupServerImpl implements LightGroupServer {

    @Autowired
    private LightingGroupMapper lightingGroupMapper;

    @Autowired
    private LightingGroupMapDao lightingGroupMapDao;

    @Autowired
    private LightingMapper lightingMapper;

    @Autowired
    private LightingGroupMapGroupDao lightingGroupMapGroupDao;

    @Override
    public int createLightGroupByLightIds(LightGroupRequest request) {
        LightingGroup lightingGroup = new LightingGroup();
        ReflectCopyUtil.beanSameFieldCopy(request, lightingGroup);
        lightingGroup.setGmtCreated(new Date());
        lightingGroup.setGmtUpdated(new Date());
        lightingGroupMapper.insertSelective(lightingGroup);

        lightingGroupMapDao.batchAddLightingGroupMap(lightingGroup.getId(), request.getLightIds());

        return 1;
    }

    @Override
    public int createLightGroupByLightUIDs(LightGroupRequest request) {
        LightingGroup lightingGroup = new LightingGroup();
        ReflectCopyUtil.beanSameFieldCopy(request, lightingGroup);
        lightingGroup.setGmtCreated(new Date());
        lightingGroup.setGmtUpdated(new Date());
        lightingGroupMapper.insertSelective(lightingGroup);

        List<String> lightUIDs = request.getLightUIDs();
        List<Long> lightIds = new ArrayList<>();
        for (String lightUID : lightUIDs) {
            LightingExample lightingExample = new LightingExample();
            lightingExample.createCriteria().andUidEqualTo(lightUID);

            List<Lighting> lightings = lightingMapper.selectByExample(lightingExample);
            for (Lighting lighting : lightings) {
                lightIds.add(lighting.getId());
            }
        }

        this.lightingGroupMapDao.batchAddLightingGroupMap(lightingGroup.getId(), lightIds);

        return 1;
    }

    @Override
    public int createLightGroupByLightGroup(LightGroupRequest request) {
        LightingGroup lightingGroup = new LightingGroup();
        ReflectCopyUtil.beanSameFieldCopy(request, lightingGroup);
        lightingGroup.setGmtCreated(new Date());
        lightingGroup.setGmtUpdated(new Date());
        lightingGroupMapper.insertSelective(lightingGroup);

        this.lightingGroupMapGroupDao.batchAddLightingGroupMapGroupMap(lightingGroup.getId(), request.getLightGroupIds());

        return 1;
    }

    @Override
    public Tuple.TwoTuple<List<LightGroupView>, Integer> listLightGroup(LightGroupConditionRequest request) {
        Tuple.TwoTuple<List<LightGroupView>, Integer> tuple = new Tuple.TwoTuple<>();
        List<LightGroupView> lightGroupViews = new ArrayList<>(8);

        LightingGroupExample lightingGroupExample = new LightingGroupExample();
        LightingGroupExample.Criteria criteria = lightingGroupExample.createCriteria();

        if (!StringUtils.isEmpty(request.getcGroupName())) {
            criteria.andCGroupNameLike("%" + request.getcGroupName() + "%");
        }

        if (request.getId() != null && request.getId() > 0) {
            criteria.andIdEqualTo(request.getId());
        }

        int total = this.lightingGroupMapper.countByExample(lightingGroupExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        lightingGroupExample.setOrderByClause("id DESC");

        List<LightingGroup> lightingGroupList = this.lightingGroupMapper.selectByExample(lightingGroupExample);

        for (LightingGroup lightingGroup : lightingGroupList) {
            LightGroupView lightGroupView = new LightGroupView();
            ReflectCopyUtil.beanSameFieldCopy(lightingGroup, lightGroupView);

            //获取组下灯具全部id
            List<LightGroupView.Lighting> viewLightingList = new ArrayList<>(8);
            List<Long> lightingIds = lightingGroupMapDao.getLightingIdsByGroupId(lightingGroup.getId());
            for (Long lightId : lightingIds) {
                Lighting lighting = this.lightingMapper.selectByPrimaryKey(lightId);
                LightGroupView.Lighting viewLight = new LightGroupView.Lighting();
                ReflectCopyUtil.beanSameFieldCopy(lighting, viewLight);
                viewLightingList.add(viewLight);
            }
            lightGroupView.setLightingList(viewLightingList);

            //获取组下全部灯具分组
            List<LightGroupView.LightingGroup> viewLightGroupList = new ArrayList<>(8);
            List<Long> lightGroupIds = lightingGroupMapGroupDao.getLightGroupIdsByGroupId(lightingGroup.getId());
            for (Long groupId : lightGroupIds) {
                LightingGroup lightingGroup1 = this.lightingGroupMapper.selectByPrimaryKey(groupId);
                LightGroupView.LightingGroup viewGroup = new LightGroupView.LightingGroup();
                ReflectCopyUtil.beanSameFieldCopy(lightingGroup1, viewGroup);
                viewLightGroupList.add(viewGroup);
            }
            lightGroupView.setLightingGroupList(viewLightGroupList);

            lightGroupViews.add(lightGroupView);
        }

        tuple.setFirst(lightGroupViews);

        return tuple;
    }
}
