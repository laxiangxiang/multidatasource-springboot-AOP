package com.multidatasource.example.demo.controller;

import com.multidatasource.example.demo.bean.Demo;
import com.multidatasource.example.demo.service.DemoTestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DemoTestController {
    @Resource
    private DemoTestService demoTestService;

    @RequestMapping("/test")
    public String test(){
     for(Demo d:demoTestService.getList()){
         System.out.println(d);
     }
        return"ok";
    }

    @RequestMapping("/test1")
    public String test1(){
//     for(Demo d:testService.getList()){
//         System.out.println(d);
//     }
        for(Demo d:demoTestService.getListByDs1()){
            System.out.println(d);
        }
        return"ok";
    }

    @RequestMapping("/test/jap")
    public Demo jpaTest(@RequestParam String name){
        return demoTestService.findByName(name);
    }
}
