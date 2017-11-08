package com.cloud.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * service
 *
 * @author xingguanghui
 * @create 2017-11-08 17:34
 **/
@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;
    Logger logger = LoggerFactory.getLogger(RibbonService.class);

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String n) {
        logger.info("service:" + n);
        String re = restTemplate.getForObject("http://CLIENT-DFS/hi?n=" + n, String.class);
        logger.info("servicere:" + re);
        return re;
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
