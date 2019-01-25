package com.bpp.bpp.shared;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SharedBeansMapperImpl implements SharedBeansMapper {

    private Map<String, SharedBeans> map;

    @Override
    public void setSharedBeansMap(Map<String, SharedBeans> map) {
        this.map = map;
    }

    @Override
    public Map<String, SharedBeans> getSharedBeansMap() {
        return map;
    }
}
