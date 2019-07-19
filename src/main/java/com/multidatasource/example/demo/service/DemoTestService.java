package com.multidatasource.example.demo.service;

import com.multidatasource.example.demo.model.Demo;
import com.multidatasource.example.demo.config.datasource.annotation.TargetDataSource;
import com.multidatasource.example.demo.dao.DemoTestDao;
import com.multidatasource.example.demo.dao.DemoTestRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoTestService {
    @Resource
    private DemoTestDao demoTestDao;

    @Resource
    private DemoTestRepository demoTestRepository;

    public void save(Demo demo){
        demoTestDao.save(demo);
    }
    /**
     * 不指定数据源使用默认数据源
     * @return
     */
    public List<Demo> getList(){
        return demoTestDao.getList();
    }

    @TargetDataSource("ds1")
    public void saveToDs1(Demo demo){
        demoTestDao.save(demo);
    }
    /**
     * 指定数据源
     * @return
     */
    @TargetDataSource("ds1")
    public List<Demo> getListFromDs1(){
        return demoTestDao.getList();
    }

    /**
     * 使用jpa，指定数据源
     * @param name
     * @return
     */
    @TargetDataSource("ds2")
    public Demo findByNameFromDs2(String name){
        return demoTestRepository.findByName(name);
    }

    @TargetDataSource("ds2")
    public void saveToDs2(){
        Demo demo = Demo.builder()
                .name("lxxds2")
                .NO(3).build();
        demoTestRepository.save(demo);
    }

    @TargetDataSource("ds1")
    public Demo findByNameFromDs1(String name){
        return demoTestRepository.findByName(name);
    }
}
