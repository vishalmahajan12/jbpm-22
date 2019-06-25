package com.cis.drool_rest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cis.drool_rest.models.FeeDataModel;
import com.cis.drool_rest.models.Payload;
import com.cis.drool_rest.services.RulesService;

@RestController
public class RulesRestController {

	@Autowired
	RulesService ruleService;
	
	@RequestMapping(value = "/applyRules", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, List> applyRules(@RequestBody Payload payloadModel) throws Exception{
		return ruleService.applyRules(payloadModel);
		
	}
	
	@RequestMapping(value = "/updateRules", method = RequestMethod.GET)
	public String applyRules(){
			return ruleService.update();
	}
}
