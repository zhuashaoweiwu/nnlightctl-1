package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.EleboxGISMapper;
import com.nnlightctl.dao.LightingGISMapper;
import com.nnlightctl.po.EleboxGIS;
import com.nnlightctl.po.EleboxGISExample;
import com.nnlightctl.po.LightingGIS;
import com.nnlightctl.po.LightingGISExample;
import com.nnlightctl.request.GISConditionRequest;
import com.nnlightctl.request.GISRequest;
import com.nnlightctl.server.GISServer;
import com.nnlightctl.vo.GISView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GISServerImpl implements GISServer {
    @Autowired
    private LightingGISMapper lightingGISMapper;

    @Autowired
    private EleboxGISMapper eleboxGISMapper;

    @Override
    public int addOrUpdateGIS(GISRequest request) {
        if (request.getType() == 0) {
            //灯具GIS
            if (request.getId() == null) {
                //新增
                LightingGIS lightingGIS = new LightingGIS();
                lightingGIS.setGmtCreated(new Date());
                lightingGIS.setGmtUpdated(new Date());

                lightingGIS.setLongitude(request.getLongitude());
                lightingGIS.setLatitude(request.getLatitude());
                lightingGIS.setMem(request.getMem());

                this.lightingGISMapper.insertSelective(lightingGIS);
            } else {
                //修改
                LightingGIS lightingGIS = new LightingGIS();
                lightingGIS.setId(request.getId());
                lightingGIS.setGmtUpdated(new Date());

                lightingGIS.setLongitude(request.getLongitude());
                lightingGIS.setLatitude(request.getLatitude());
                lightingGIS.setMem(request.getMem());

                this.lightingGISMapper.updateByPrimaryKeySelective(lightingGIS);
            }
        } else if (request.getType() == 1) {
            //控制柜GIS
            if (request.getId() == null) {
                //新增
                EleboxGIS eleboxGIS = new EleboxGIS();
                eleboxGIS.setGmtCreated(new Date());
                eleboxGIS.setGmtUpdated(new Date());

                eleboxGIS.setLongitude(request.getLongitude());
                eleboxGIS.setLatitude(request.getLatitude());
                eleboxGIS.setMem(request.getMem());

                this.eleboxGISMapper.insertSelective(eleboxGIS);
            } else {
                //修改
                EleboxGIS eleboxGIS = new EleboxGIS();
                eleboxGIS.setId(request.getId());
                eleboxGIS.setGmtUpdated(new Date());

                eleboxGIS.setLongitude(request.getLongitude());
                eleboxGIS.setLatitude(request.getLatitude());
                eleboxGIS.setMem(request.getMem());

                this.eleboxGISMapper.updateByPrimaryKeySelective(eleboxGIS);
            }
        }

        return 1;
    }

    @Override
    public int deleteGIS(GISConditionRequest request) {
        List<Long> idList = request.getGisIDList();
        for (Long id : idList) {
            if (request.getType() == 0) {
                this.lightingGISMapper.deleteByPrimaryKey(id);
            } else {
                this.eleboxGISMapper.deleteByPrimaryKey(id);
            }
        }

        return 1;
    }

    @Override
    public Tuple.TwoTuple<List<GISView>, Integer> listGIS(GISConditionRequest request) {
        Tuple.TwoTuple<List<GISView>, Integer> tuple = new Tuple.TwoTuple<>();
        if (request.getType() == 0) {
            //灯具GIS
            LightingGISExample lightingGISExample = new LightingGISExample();
            int total = this.lightingGISMapper.countByExample(lightingGISExample);

            lightingGISExample.setOrderByClause("id DESC");
            PageHelper.startPage(request.getPageNumber(), request.getPageSize());

            List<LightingGIS> lightingGIS = this.lightingGISMapper.selectByExample(lightingGISExample);
            List<GISView> gisViews = new ArrayList<>(10);
            for (LightingGIS lightingGIS1 : lightingGIS) {
                GISView gisView = new GISView();
                gisView.setId(lightingGIS1.getId());
                gisView.setGmtCreated(lightingGIS1.getGmtCreated());
                gisView.setGmtUpdated(lightingGIS1.getGmtUpdated());
                gisView.setLongitude(lightingGIS1.getLongitude());
                gisView.setLantitude(lightingGIS1.getLatitude());
                gisView.setMem(lightingGIS1.getMem());

                gisViews.add(gisView);
            }

            tuple.setFirst(gisViews);
            tuple.setSecond(total);
        } else {
            //控制柜GIS
            EleboxGISExample eleboxGISExample = new EleboxGISExample();
            int total = this.eleboxGISMapper.countByExample(eleboxGISExample);

            eleboxGISExample.setOrderByClause("id DESC");
            PageHelper.startPage(request.getPageNumber(), request.getPageSize());

            List<EleboxGIS> eleboxGISList = this.eleboxGISMapper.selectByExample(eleboxGISExample);
            List<GISView> gisViews = new ArrayList<>(10);
            for (EleboxGIS eleboxGIS : eleboxGISList) {
                GISView gisView = new GISView();
                gisView.setId(eleboxGIS.getId());
                gisView.setGmtCreated(eleboxGIS.getGmtCreated());
                gisView.setGmtUpdated(eleboxGIS.getGmtUpdated());

                gisView.setLongitude(eleboxGIS.getLongitude());
                gisView.setLantitude(eleboxGIS.getLatitude());
                gisView.setMem(eleboxGIS.getMem());

                gisViews.add(gisView);
            }

            tuple.setFirst(gisViews);
            tuple.setSecond(total);
        }

        return tuple;
    }
}
