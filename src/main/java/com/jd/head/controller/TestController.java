package com.jd.head.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jd.head.model.JsonResult;
import com.jd.head.model.SearchBO;
import com.jd.head.util.JsonUtil;

@Controller
public class TestController {
	private Logger log = Logger.getLogger(getClass());

	@RequestMapping("show")
	public String show(SearchBO bo, ModelMap result) {
		String message = JsonUtil.object2String(bo);
		log.debug("search time ="+bo.getTime());
		log.debug("start to handle show request");
		result.put("message", message);
		return "showMessage";
	}

	@ResponseBody
	@RequestMapping("ajax")
	public JsonResult json() {
		String message = "hello spring!";
		log.debug("start to handle show request");
		JsonResult jr = new JsonResult();
		jr.setCreated(new Date());
		jr.setId(System.currentTimeMillis());
		jr.setMessage(message);
		jr.setModified(new Date().getTime());
		return jr;
	}
}
