package com.mp.swagger.model.request;

import com.mp.swagger.Valid.Phone;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel(description = "订单信息")
public class OrderData implements Serializable {

    @ApiModelProperty(value = "订单号",name = "",dataType = "String",required =true,example = "orderNo")
    @NotBlank(message = "订单号不能为空")
    private String orderNo;

    @Phone
    private String phone;


    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
