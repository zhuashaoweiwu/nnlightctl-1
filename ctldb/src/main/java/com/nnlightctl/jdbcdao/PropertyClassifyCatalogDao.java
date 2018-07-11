package com.nnlightctl.jdbcdao;

import com.nnlightctl.po.PropertyClassifyCatalog;

import java.util.List;

public interface PropertyClassifyCatalogDao {

    List<PropertyClassifyCatalog> listAllChildren(List<Long> propertyClassifyCatalogIds);

    List<PropertyClassifyCatalog> listPropertyClassifyCatalogLevel1();
}
