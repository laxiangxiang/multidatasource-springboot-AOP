package com.multidatasource.example.demo.controller;

import com.multidatasource.example.demo.common.JsonData;
import com.multidatasource.example.demo.model.Demo;
import com.multidatasource.example.demo.service.DemoTestService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DemoTestController {
    @Resource
    private DemoTestService demoTestService;

    @RequestMapping("/default/save")
    public String defaultSave(){
        Demo demo = new Demo();
        demo.setName("lxx");
        demo.setNO(1);
        demoTestService.save(demo);
        return "ok";
    }

    @RequestMapping("/default/list")
    public String defaultList(){
        for(Demo d:demoTestService.getList()){
            System.out.println(d);
        }
        return"ok";
    }

    @RequestMapping("/ds1/save")
    public String ds1Save(){
        Demo demo = new Demo();
        demo.setName("lxxds1");
        demo.setNO(2);
        demoTestService.saveToDs1(demo);
        return "ok";
    }

    @RequestMapping("/ds1/list")
    public String ds1List(){
        for(Demo d:demoTestService.getListFromDs1()){
            System.out.println(d);
        }
        return"ok";
    }

    @RequestMapping(value = "/jpa/default/get",produces = MediaType.APPLICATION_JSON_VALUE)
    public Demo jpaTest(){
        return demoTestService.findByNameFromDs2("lxx");
    }

    @RequestMapping(value = "/jpa/ds2/save")
    public JsonData saveDemo(){
//        param = new DemoParam(1,"yang",123);
//        BeanValidator.check(param);
        demoTestService.saveToDs2();
        return JsonData.success();
    }

    @RequestMapping(value = "/jpa/ds1/get")
    public JsonData findByNameFromDB1(){
        Demo demo = demoTestService.findByNameFromDs1("lxxds1");
        return JsonData.success(demo);
    }
}
