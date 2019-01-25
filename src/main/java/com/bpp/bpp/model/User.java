package com.bpp.bpp.model;

import com.bpp.bpp.processor.annotation.BeansMapping;
import com.bpp.bpp.shared.SharedBeans;

public class User implements SharedBeans {

    @BeansMapping(key = "User")
    public void getInfo() {
        System.out.println("User");
    }
}
