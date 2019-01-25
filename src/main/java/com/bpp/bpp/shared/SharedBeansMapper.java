package com.bpp.bpp.shared;

import java.util.Map;

public interface SharedBeansMapper {
    void setSharedBeansMap(Map<String, SharedBeans> map);
    Map<String, SharedBeans> getSharedBeansMap();
}
