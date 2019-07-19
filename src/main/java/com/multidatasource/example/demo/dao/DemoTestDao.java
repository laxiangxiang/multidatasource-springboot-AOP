package com.multidatasource.example.demo.dao;

import com.multidatasource.example.demo.model.Demo;
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

    public void save(Demo demo){
        jdbcTemplate.execute("insert into demo values (null,"+demo.getNO()+",'"+demo.getName()+"')");
    }

    public List<Demo> getList(){
        String sql = "select * from Demo";
        return jdbcTemplate.query(sql, new RowMapper<Demo>() {
            @Override
            public Demo mapRow(ResultSet resultSet, int i) throws SQLException {
                Demo demo = new Demo();
                demo.setId(resultSet.getInt("id"));
                demo.setNO(resultSet.getInt("no"));
                demo.setName(resultSet.getString("name"));
                return  demo;
            }
        });
    }
}
