package com.nnlightctl.server;

import com.nnlightctl.po.PropertyClassifyCatalog;
import com.nnlightctl.request.PropertyClassifyCatalogRequest;

import java.util.List;

public interface PropertyClassifyCatalogServer {
    int addOrUpdatePropertyClassifyCatalog(PropertyClassifyCatalogRequest request);
    List<PropertyClassifyCatalog> propertyClassifyCatalog(List<Long> propertyClassifyCatalogIds);
    int deletePropertyClassifyCatalog(List<Long> propertyClassifyCatalogIds);
    List<PropertyClassifyCatalog> listPropertyClassifyCatalogLevel1();
}
