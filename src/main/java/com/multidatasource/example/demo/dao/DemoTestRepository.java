package com.multidatasource.example.demo.dao;

import com.multidatasource.example.demo.model.Demo;
import com.multidatasource.example.demo.param.DemoParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoTestRepository extends JpaRepository<Demo,Long>{

    Demo findByName(String name);
}
