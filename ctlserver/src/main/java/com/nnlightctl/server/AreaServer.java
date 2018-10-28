package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.Region;
import com.nnlightctl.request.AreaConditionRequest;
import com.nnlightctl.request.AreaRequest;
import com.nnlightctl.vo.RegionView;

import java.util.List;

public interface AreaServer {
    int addOrUpdateArea(AreaRequest request);
    int deleteArea(AreaConditionRequest request);

    Tuple.TwoTuple<List<Region>, Integer> listArea(AreaConditionRequest request);

    List<Region> listLevel1Area();

    List<Region> listSubArea(Long parentAreaId);

    Region getAreaById(Long id);

    List<RegionView> getLevelRegion();
}
