package com.larscheng.www.jpa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author: larscheng
 * @date: 2020/4/28 下午2:56
 * @description:
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String password;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }
}
