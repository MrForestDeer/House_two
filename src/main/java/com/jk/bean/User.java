package com.jk.bean;

import lombok.Data;

@Data
public class User {
    private String name;//账户:
    private String paword;//密码:
    private String Code;//验证码
    private String emali;//邮箱:
    private String username;//有户名:
    private String position;//职位:
    private String sex;//性别：
    private Integer age;//年龄:
    private String phone;//手机号:
}
