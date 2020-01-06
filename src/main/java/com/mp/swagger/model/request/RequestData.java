package com.mp.swagger.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel(description = "url请求参数")
public class RequestData implements Serializable {
    //1.验证信息
    @ApiModelProperty(value = "企业编号",dataType = "String",name = "",required =true,example = "appId")
    @NotBlank(message = "企业编号不能为空")
    private String  appId;
    @ApiModelProperty(value = "企业密钥",dataType = "String",name = "",required =true,example = "appkey")
    @NotBlank(message = "企业密钥不能为空")
    private String  appkey;
    @ApiModelProperty(value = "密文",dataType = "String",name = "",required =true,example = "sign")
    @NotBlank(message = "密文不能为空")
    private String  sign;

    //2.订单信息
    @Valid
    private OrderData  orderData;


    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public OrderData getOrderData() {
        return orderData;
    }

    public void setOrderData(OrderData orderData) {
        this.orderData = orderData;
    }
}
