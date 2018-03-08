package com.multidatasource.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Demo {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer NO;

    public Integer getNO() {
        return NO;
    }

    public void setNO(Integer NO) {
        this.NO = NO;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", NO=" + NO +
                '}';
    }

}
