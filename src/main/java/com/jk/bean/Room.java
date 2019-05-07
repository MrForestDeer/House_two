package com.jk.bean;

import lombok.Data;

@Data
public class Room {
    private Integer  romid;//主键
    private String romame;//房东姓名
    private String romddress;//房东地址
    private String romnumber;//房东手机号
    private String stemindatetime;//合同开始时间
    private String endmaxdatetime;//合同结束时间
    private Integer      romstate;//合同状态 1=正常，出现查看房东详情弹框 2=完善信息  修改添加未写的信息 3=到期查看房东详情弹框
    private String romphone;//联系电话
    private String romurgent;//紧急联系人
    private String romidentitynumber;//身份证号码
    private String rommany;//每月租金
    private String romdeposit;//押金余额
    private Integer     romPaymentmethod;//房租支付方式
    private String romkong;//房屋空置期
    private Integer    romintkong;//免租期
    private Integer    romwater;//水费
    private Integer   romelectric;//电费
    private Integer romgasl;//天然气
    private String romweizhi;//位置
    private Integer     tenzhangdai;//账单类型
    private Integer  tenshouk;//收款状态1=确认收款 2给自己的资金添加支出 -号
    private Integer rommianji;//面积
    private Integer romhuxing;//三目判断
    private Integer romflg;//房源状况
    private String romnfn;//合同备注

}
