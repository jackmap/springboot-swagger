package com.mp.swagger.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "返回体")
public class RetrunMessage implements Serializable {

	@ApiModelProperty(value = "消息体",required = true,example = "返回的消息代码")
	private Integer code;
	@ApiModelProperty(value = "消息总结",required = true,example ="返回的消息信息" )
	private String message;
	@ApiModelProperty(value = "消息总结",example = "返回的错误信息")
	private String erorrdata;
	@ApiModelProperty(value = "消息体",example = "返回的信息体")
	private String data;

	public RetrunMessage(Integer code, String message, String erorrdata, String data) {
		this.code = code;
		this.message = message;
		this.erorrdata = erorrdata;
		this.data = data;
	}

	public RetrunMessage(Integer code, String message, String data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	public RetrunMessage(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErorrdata() {
		return erorrdata;
	}

	public void setErorrdata(String erorrdata) {
		this.erorrdata = erorrdata;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
