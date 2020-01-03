package com.mp.swagger.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel
public class ExampleData {

    @ApiModelProperty(notes = "用户名, 不能为空, 否则后端抛出异常")
    @NotNull(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(notes = "密码, 密码不能为空且不能为简单密码, 否则后端抛出异常")
    @NotNull(message = "密码不能为空")
    private String password;

    @ApiModelProperty(notes = "当前注册用户所属的国家名称, 不能为空, 否则后端抛出异常")
    @NotNull(message = "所属国家不能为空")
    private String country;


}
