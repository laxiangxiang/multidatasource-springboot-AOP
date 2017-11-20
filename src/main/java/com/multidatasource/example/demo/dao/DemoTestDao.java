package com.multidatasource.example.demo.dao;

import com.multidatasource.example.demo.bean.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class DemoTestDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 不指定数据源使用默认数据源
     * @return
     */
    public List<Demo> getList(){
        String sql = "select * from Demo1";
        return jdbcTemplate.query(sql, new RowMapper<Demo>() {
            @Override
            public Demo mapRow(ResultSet resultSet, int i) throws SQLException {
                Demo demo = new Demo();
                demo.setId(resultSet.getInt("id"));
                demo.setName(resultSet.getString("name"));
                return  demo;
            }
        });
    }

    public List<Demo> getListByDs1(){
        String sql = "select * from demo1";
        return (List<Demo>) jdbcTemplate.query(sql, new RowMapper<Demo>() {
            @Override
            public Demo mapRow(ResultSet resultSet, int i) throws SQLException {
                Demo demo = new Demo();
                demo.setId(resultSet.getInt("id"));
                demo.setName(resultSet.getString("name"));
                return  demo;
            }
        });
    }
}
