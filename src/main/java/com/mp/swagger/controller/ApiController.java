package com.mp.swagger.controller;

import com.mp.swagger.config.BaseResult;
import com.mp.swagger.model.request.RequestData;
import com.mp.swagger.model.response.RetrunMessage;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Base64;
import java.util.List;

@Api(tags="报文服务Api",value = "/api/baowei", description = "报文服务 API")
@RestController
@RequestMapping("/api")
public class ApiController {
   private  static final Logger log= LoggerFactory.getLogger(ApiController.class);

    /**
	 *
	 *
	 * */
	@RequestMapping(value="/baowen/test",
			method=RequestMethod.POST,
			produces="application/json",
			consumes="application/json"
	)
	@ApiOperation(value = "报文服务Api",notes = "上传正确的订单信息和物流信息", httpMethod = "POST")
	@ApiResponses({
			@ApiResponse(code = HttpServletResponse.SC_OK,message = "成功"),
			@ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR,message = "失败",reference = "RetrunMessage"),
			@ApiResponse(code = HttpServletResponse.SC_CONFLICT, message = "当前用户没有做到swagger使用规范")
	})
	public BaseResult<RetrunMessage> create(@RequestBody @Valid RequestData requestData, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
        	List<ObjectError> errorlist=bindingResult.getAllErrors();
			for (ObjectError error:errorlist ) {
				log.error(error.getDefaultMessage());
				System.err.println(error.getDefaultMessage());
			}
        	String errorMsg=errorlist.get(0).getDefaultMessage();
        	return BaseResult.failWithCodeAndMsg(1,errorMsg);
		}
		String  a= Base64.getEncoder().encodeToString(requestData.getCompanyName().getBytes());
        System.out.println(a);
		byte[] sign= Base64.getDecoder().decode(requestData.getSign());
		System.out.println(new String(sign));
		if (a.equals(requestData.getSign())) {
			RetrunMessage messge=new RetrunMessage(0,"上传成功");
			return BaseResult.successWithData(messge);
		} else {
			return BaseResult.failWithCodeAndMsg(1,"sign验证失败");
		}
	}


}
