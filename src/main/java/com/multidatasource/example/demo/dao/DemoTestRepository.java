package com.multidatasource.example.demo.dao;

import com.multidatasource.example.demo.bean.Demo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoTestRepository extends CrudRepository<Demo,Long>{

    Demo findByName(String name);
}
