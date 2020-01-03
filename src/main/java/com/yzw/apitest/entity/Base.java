package com.yzw.apitest.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Base {
    private Long id;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;
    private int deleteTag;
}
