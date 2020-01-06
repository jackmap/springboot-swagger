package com.mp.swagger.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel(description = "订单信息")
public class OrderData implements Serializable {

    @ApiModelProperty(value = "订单号",name = "",dataType = "String",required =true,example = "orderNo")
    @NotBlank(message = "订单号不能为空")
    private String orderNo;





    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
