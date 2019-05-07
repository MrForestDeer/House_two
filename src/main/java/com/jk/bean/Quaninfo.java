package com.jk.bean;

import lombok.Data;

@Data
public class Quaninfo {
    private Integer infoid;//权限或者说职位表主键

    private String infourl;//放行给予的页面

    private String infoname;//防行的url名称

    private Integer ssionsid;//权限角色中间表  权限的id

}
