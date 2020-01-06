package com.mp.swagger.controller;

import com.mp.swagger.config.BaseResult;
import com.mp.swagger.model.ExampleData;
import com.mp.swagger.model.ExampleReponse;
import com.mp.swagger.model.request.OrderData;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;


@Api(value = "报文服务Api", description = "报文服务 API")
@RestController
@RequestMapping("/api")
public class TestController {

    @RequestMapping(value="/api/test", method=RequestMethod.POST)
    @ApiOperation(value = "报文服务Api",notes = "上传正确的订单信息和物流信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "消息 ID", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "text", value = "正文", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "summary", value = "摘要", required = false, dataType = "String", paramType = "query"),
    })
    @ApiResponses({
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "成功"),
            @ApiResponse(code = HttpServletResponse.SC_CONFLICT, message = "当前用户没有做到swagger使用规范")
    })
    public ExampleReponse create(@Valid @RequestBody ExampleData exampleData) {

        return  new ExampleReponse();
    }




    @ApiOperation(
            value = "消息列表",
            notes = "完整的消息内容列表",
            produces="application/json, application/xml",
            consumes="application/json, application/xml",
            response = List.class)
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 100, message = "请求参数有误"),
            @ApiResponse(code = 101, message = "未授权"),
            @ApiResponse(code = 103, message = "禁止访问"),
            @ApiResponse(code = 104, message = "请求路径不存在"),
            @ApiResponse(code = 200, message = "服务器内部错误")
    })
    public List<OrderData> getUserList() {
        return new ArrayList<>();
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "ipAddr", value = "ip哟", required = false, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "", method = RequestMethod.POST)
    public BaseResult<OrderData> postUser(@ApiIgnore OrderData user) {
        return BaseResult.successWithData(user);
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public OrderData getUser(@PathVariable Long id) {
        return new OrderData();
    }

    @ApiOperation(value = "更新用户信息", notes = "根据用户ID更新信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "String", paramType = "query")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public BaseResult<OrderData> putUser(@PathVariable Long id, @ApiIgnore OrderData user) {
        return BaseResult.success();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        return "success";
    }

    @RequestMapping(value = "/ignoreMe/{id}", method = RequestMethod.DELETE)
    public String ignoreMe(@PathVariable Long id) {
        return "success";
    }
}