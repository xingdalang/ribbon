package com.cloud.ribbon.controller;

import com.cloud.ribbon.service.RibbonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * dodsfad
 *
 * @author xingguanghui
 * @create 2017-11-08 17:34
 **/
@Controller
public class RibbonController {
    Logger logger = LoggerFactory.getLogger(RibbonController.class);

    @Autowired
    RibbonService ribbonService;
    @RequestMapping(value = "/hi")
    @ResponseBody
    public String hi(@RequestParam String n){
        logger.info("ribbonsController:"+n);
        return ribbonService.hiService(n);
    }

}
