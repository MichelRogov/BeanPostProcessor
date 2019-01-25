package com.bpp.bpp.service.impl;

import com.bpp.bpp.processor.annotation.BeansMapping;
import com.bpp.bpp.service.SearchService;
import com.bpp.bpp.shared.SharedBeans;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImp implements SearchService, SharedBeans {

    @BeansMapping(key = "SearchService")
    public void getInfo() {
        System.out.println("SearchService");
    }

    // code here

}
