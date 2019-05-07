package com.jk.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Role {
    private Integer rid; //主键
    private String rolename;//角色名称
    private Date  createDate;//创建时间****************
}
