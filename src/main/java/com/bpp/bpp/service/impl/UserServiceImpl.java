package com.bpp.bpp.service.impl;

import com.bpp.bpp.processor.annotation.BeansMapping;
import com.bpp.bpp.service.UserService;
import com.bpp.bpp.shared.SharedBeans;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, SharedBeans {

    @BeansMapping(key = "UserService")
    public void getInfo() {
        System.out.println("UserService");
    }
}
