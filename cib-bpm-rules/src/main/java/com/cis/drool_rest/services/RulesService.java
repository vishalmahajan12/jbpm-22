package com.cis.drool_rest.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import com.cis.drool_rest.models.Payload;
import com.cis.drool_rest.utils.CommonUtils;

@Service
public class RulesService {
	
	
	public Map<String, List> applyRules(Payload payloadModel) throws Exception{
		System.out.println("Input DataModel: " + payloadModel);
		KieSession kSession = CommonUtils.createKession();
		 Map<String, List> result = new HashMap<>();
		if(kSession != null){
			if(null != payloadModel ){
	    		System.out.println("####### Rules Fired #######");
	    		kSession.insert(payloadModel);
	    		
	    		List approvalList = new ArrayList();
				List verifierList = new ArrayList();
				
				kSession.setGlobal("approvalList", approvalList);
				kSession.setGlobal("verifierList", verifierList);
	    		
	            kSession.fireAllRules();
	            kSession.dispose();
	            
	           
	            result.put("approvalList", approvalList);
	            result.put("verifierList", verifierList);
	            System.out.println("Output : " + result);
	    	}
	    	
		}
		return result;
	}
	
	public String update(){
		try {
			CommonUtils.initialize();
			return "Rules updated Successfully!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Exception while updating rules. Exception: " + e.toString();
		}
	}
	
}
