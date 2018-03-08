package com.multidatasource.example.demo.controller;

import com.multidatasource.example.demo.common.JsonData;
import com.multidatasource.example.demo.model.Demo;
import com.multidatasource.example.demo.param.DemoParam;
import com.multidatasource.example.demo.service.DemoTestService;
import com.multidatasource.example.demo.util.BeanValidator;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping("/test/jpa")
    public Demo jpaTest(@RequestParam String name){
        return demoTestService.findByName(name);
    }

    @RequestMapping(value = "/test/jpa/save"
            ,method = RequestMethod.POST
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonData saveDemo(DemoParam param){
        param = new DemoParam(1,"yang",123);
        BeanValidator.check(param);
//        demoTestService.saveDemodb(param);
        demoTestService.saveDemoTodb1(param);
        return JsonData.success();
    }

    @RequestMapping(value = "/test/jpa/findFromDB1")
    public JsonData findByNameFromDB1(@RequestParam String name){
        Demo demo = demoTestService.findByNameFromDB1(name);
        return JsonData.success(demo);
    }
}
