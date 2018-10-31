package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.RegionMapper;
import com.nnlightctl.po.Region;
import com.nnlightctl.po.RegionExample;
import com.nnlightctl.request.AreaConditionRequest;
import com.nnlightctl.request.AreaRequest;
import com.nnlightctl.server.AreaServer;
import com.nnlightctl.vo.RegionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AreaServerImpl implements AreaServer {
    @Autowired
    private RegionMapper regionMapper;

    @Override
    public int addOrUpdateArea(AreaRequest request) {
        Region region = new Region();
        ReflectCopyUtil.beanSameFieldCopy(request, region);
        region.setGmtUpdated(new Date());
        if (request.getId() == null) {
            //新增
            region.setGmtCreated(new Date());
            this.regionMapper.insertSelective(region);
        } else {
            //修改
            this.regionMapper.updateByPrimaryKeySelective(region);
        }

        return 1;
    }

    @Override
    public int deleteArea(AreaConditionRequest request) {
        List<Long> idList = request.getAreaIdList();
        for (Long id : idList) {
            this.regionMapper.deleteByPrimaryKey(id);
        }
        return 1;
    }

    @Override
    public Tuple.TwoTuple<List<Region>, Integer> listArea(AreaConditionRequest request) {
        Tuple.TwoTuple<List<Region>, Integer> tuple = new Tuple.TwoTuple<>();
        RegionExample regionExample = new RegionExample();
        int total = this.regionMapper.countByExample(regionExample);

        regionExample.setOrderByClause("id DESC");

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<Region> regionList = this.regionMapper.selectByExample(regionExample);

        tuple.setFirst(regionList);
        tuple.setSecond(total);

        return tuple;
    }

    @Override
    public List<Region> listLevel1Area() {
        RegionExample regionExample = new RegionExample();
        regionExample.createCriteria().andRegionLevelEqualTo((byte)0);
        regionExample.setOrderByClause("id DESC");

        return regionMapper.selectByExample(regionExample);
    }

    @Override
    public List<Region> listSubArea(Long parentAreaId) {
        RegionExample regionExample = new RegionExample();
        regionExample.createCriteria().andNnlightctlParentRegionEqualTo(parentAreaId);
        regionExample.setOrderByClause("id DESC");

        return regionMapper.selectByExample(regionExample);
    }

    @Override
    public Region getAreaById(Long id) {
        return regionMapper.selectByPrimaryKey(id);
    }

    private List<RegionView> doMergeRegion(Region parentRegion, List<Region> regionList) {
        List<RegionView> regionViews = new ArrayList<>(8);

        for (Region region : regionList) {
            if (region.getNnlightctlParentRegion() != null && region.getNnlightctlParentRegion().equals(parentRegion.getId())) {
                RegionView regionView = new RegionView();
                ReflectCopyUtil.beanSameFieldCopy(region, regionView);
                regionView.setSubRegionViewList(doMergeRegion(region, regionList));
                regionViews.add(regionView);
            }
        }

        return regionViews;
    }

    private List<RegionView> mergeRegion(List<Region> regions) {
        List<RegionView> regionViews = new ArrayList<>(8);

        for (Region region : regions) {
            if (region.getRegionLevel() == 0) {
                RegionView regionView = new RegionView();
                ReflectCopyUtil.beanSameFieldCopy(region, regionView);
                regionView.setSubRegionViewList(doMergeRegion(region, regions));
                regionViews.add(regionView);
            }
        }

        return regionViews;
    }

    @Override
    public List<RegionView> getLevelRegion() {
        //1、获取全部区域信息
        List<Region> regionList = regionMapper.selectByExample(new RegionExample());
        //2、递归构造层级区域信息集合
        return mergeRegion(regionList);
    }

    @Override
    public String getLevelRegionDesc(Long id) {
        Region region = regionMapper.selectByPrimaryKey(id);
        if (region.getNnlightctlParentRegion() != null) {
            return getLevelRegionDesc(region.getNnlightctlParentRegion()) + "-" + region.getAreaName();
        }
        return region.getAreaName();
    }
}
