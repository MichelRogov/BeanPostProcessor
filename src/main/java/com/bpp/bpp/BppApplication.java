package com.bpp.bpp;

import com.bpp.bpp.shared.SharedBeans;
import com.bpp.bpp.shared.SharedBeansMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

@SpringBootApplication
public class BppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BppApplication.class, args);
        Map<String, SharedBeans> sharedBeansMap = context.getBean(SharedBeansMapper.class).getSharedBeansMap();

        sharedBeansMap.get("SearchService").getInfo();
        sharedBeansMap.get("UserService").getInfo();
        sharedBeansMap.get("User").getInfo();
    }
}

