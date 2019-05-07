package com.jk.bean;

import lombok.Data;

@Data
public class Shouzhi {
    private Integer szid; //主键
    private Integer ros;//房东ID 给他的就是支出
    private Integer tomz;//租客ID 他给我的就是收
}
