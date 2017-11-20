package com.multidatasource.example.demo.service;

import com.multidatasource.example.demo.bean.Demo;
import com.multidatasource.example.demo.config.datasource.dynamic.TargetDataSource;
import com.multidatasource.example.demo.dao.DemoTestDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoTestService {
    @Resource
    private DemoTestDao demoTestDao;

    /**
     * 不指定数据源使用默认数据源
     * @return
     */
    public List<Demo> getList(){
        return demoTestDao.getList();
    }

    /**
     * 指定数据源
     * @return
     */
    @TargetDataSource("ds1")
    public List<Demo> getListByDs1(){
        return demoTestDao.getListByDs1();
    }
}
