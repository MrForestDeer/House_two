package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Tenant {
    private Integer  teid;//主键
    private String tename;//租客姓名
    private String teaddress;//租客地址
    private String tenumber;//租客房号
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date stemindatetime;//合同开始时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endmaxdatetime;//合同结束时间
    private Integer      tenstate;//合同状态 1=正常，出现查看租客详情弹框 2=完善信息  修改添加未写的信息 3=到期删除该用户
    private String tenphone;//联系电话
    private String tenurgent;//紧急联系人
    private String tenidentitynumber;//身份证号码
    private String tenmany;//每月租金
    private String tendeposit;//押金余额
    private Integer      tenPaymentmethod;//支付方式
    private Integer     tenwater;//水费
    private Integer     tenelectric;//电费
    private Integer     tengasl;//天然气
    private Integer     tenzhangdai;//账单类型
    private Integer    tenshouk;//收款状态1=确认收款 2给自己的资金添加支出 +号
    private String teninfn;//合同备注

}
