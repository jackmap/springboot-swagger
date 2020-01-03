package com.mp.swagger.controller;

import com.mp.swagger.config.BaseResult;
import com.mp.swagger.model.ExampleData;
import com.mp.swagger.model.ExampleReponse;
import com.mp.swagger.model.Message;
import com.mp.swagger.repository.MessageRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Api(value = "报文服务Api", description = "报文服务 API")
@RestController
@RequestMapping("/api")
public class TestController {

	@Autowired
	private MessageRepository messageRepository;


	@RequestMapping(value="/test", method=RequestMethod.POST)
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




}
