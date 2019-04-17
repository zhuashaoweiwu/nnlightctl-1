package com.nnlightctl.server.impl;

import com.nnlight.common.ReflectCopyUtil;
import com.nnlightctl.dao.PropertyClassifyCatalogMapper;
import com.nnlightctl.jdbcdao.PropertyClassifyCatalogDao;
import com.nnlightctl.po.Property;
import com.nnlightctl.po.PropertyClassifyCatalog;
import com.nnlightctl.po.PropertyClassifyCatalogExample;
import com.nnlightctl.po.Supplier;
import com.nnlightctl.request.PropertyClassifyCatalogRequest;
import com.nnlightctl.server.PropertyClassifyCatalogServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PropertyClassifyCatalogServerImpl implements PropertyClassifyCatalogServer {
    @Autowired
    private PropertyClassifyCatalogMapper propertyClassifyCatalogMapper;
    @Autowired
    private PropertyClassifyCatalogDao propertyClassifyCatalogDao;
    @Override
    public int addOrUpdatePropertyClassifyCatalog(PropertyClassifyCatalogRequest request){
        PropertyClassifyCatalog propertyClassifyCatalog = new PropertyClassifyCatalog();
        ReflectCopyUtil.beanSameFieldCopy(request, propertyClassifyCatalog);
        propertyClassifyCatalog.setGmtUpdated(new Date());

        int ret = -1;
        if (request.getId() == null) {
            //新增
            propertyClassifyCatalog.setGmtCreated(new Date());

            ret = propertyClassifyCatalogMapper.insertSelective(propertyClassifyCatalog);
        } else {
            //修改
            ret = propertyClassifyCatalogMapper.updateByPrimaryKeySelective(propertyClassifyCatalog);
        }

        return ret;
    }
    @Override
    public List<PropertyClassifyCatalog> listPropertyClassifyCatalog(List<Long> propertyClassifyCatalogIds){
        List<Long> ids = new ArrayList<Long>();
        List<PropertyClassifyCatalog> propertyClassifyCatalogList = new ArrayList<PropertyClassifyCatalog>();
        List<PropertyClassifyCatalog> propertyClassifyCatalogList1 = new ArrayList<PropertyClassifyCatalog>();
        List<PropertyClassifyCatalog> propertyClassifyCatalogList2 = new ArrayList<PropertyClassifyCatalog>();
        List<Long> propertyClassifyCatalogIds1 = new ArrayList<>();
        for (int i = 0; i < propertyClassifyCatalogIds.size(); i++) {
                PropertyClassifyCatalog propertyClassifyCatalog = propertyClassifyCatalogMapper.selectByPrimaryKey(propertyClassifyCatalogIds.get(i));
                propertyClassifyCatalogList.add(propertyClassifyCatalog);
        }
        for (int j = 0 ;j < propertyClassifyCatalogList.size() ; j++) {
            propertyClassifyCatalogIds1.add(propertyClassifyCatalogList.get(j).getId());
        }
        propertyClassifyCatalogList1 = propertyClassifyCatalogDao.listAllChildren(propertyClassifyCatalogIds1);
        List<Long> propertyClassifyCatalogIds2 = new ArrayList<>();
        for(int k = 0 ;k<propertyClassifyCatalogList1.size() ;k++){
            propertyClassifyCatalogIds2.add(propertyClassifyCatalogList1.get(k).getId());
            propertyClassifyCatalogList2 = listPropertyClassifyCatalog(propertyClassifyCatalogIds2);
            if (propertyClassifyCatalogList2.isEmpty()) {
                break;
            }
        }
        propertyClassifyCatalogList.addAll(propertyClassifyCatalogList2);

        return propertyClassifyCatalogList;
    }

    public List<PropertyClassifyCatalog> listPropertyClassifyCatalogAll(Long id){
       // List<PropertyClassifyCatalog> propertyClassifyCatalogList = propertyClassifyCatalog(propertyClassifyCatalogIds);
        PropertyClassifyCatalogExample propertyClassifyCatalogExample = new PropertyClassifyCatalogExample();
        propertyClassifyCatalogExample.createCriteria().andNnlightctlPropertyClassifyCatalogIdEqualTo(id);
        List<PropertyClassifyCatalog> propertyClassifyCatalogList = propertyClassifyCatalogMapper.selectByExample(propertyClassifyCatalogExample);
        return propertyClassifyCatalogList;
    }
    @Override
    public  int deletePropertyClassifyCatalog(List<Long> propertyClassifyCatalogIds){
        List<PropertyClassifyCatalog> propertyClassifyCatalogList = listPropertyClassifyCatalog(propertyClassifyCatalogIds);
        for (int j = 0 ;j < propertyClassifyCatalogList.size() ; j++) {
            propertyClassifyCatalogMapper.deleteByPrimaryKey(propertyClassifyCatalogList.get(j).getId());
        }
        return 1;
    }
    @Override
    public List<PropertyClassifyCatalog> listPropertyClassifyCatalogLevel1(){
        return propertyClassifyCatalogDao.listPropertyClassifyCatalogLevel1();
    }

    @Override
    public String getPropertyClassifyCatalogDesc(Long id) {
        StringBuilder stringBuilder = new StringBuilder();
        PropertyClassifyCatalog propertyClassifyCatalog = propertyClassifyCatalogMapper.selectByPrimaryKey(id);
        if (propertyClassifyCatalog.getNnlightctlPropertyClassifyCatalogId() != null) {
            stringBuilder.append(getPropertyClassifyCatalogDesc(propertyClassifyCatalog.getNnlightctlPropertyClassifyCatalogId()));
            stringBuilder.append("-");
        }
        stringBuilder.append(propertyClassifyCatalog.getMyCatalogName());
        return stringBuilder.toString();
    }
}
