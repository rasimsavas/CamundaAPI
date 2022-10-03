package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.json.JSONObject;

public class Account implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		var tc = execution.getVariable("KEYINPUTTC");
		var amount = execution.getVariable("amount");
		
		JSONObject json = new JSONObject();
		json.append("TC", tc);
		json.append("amount", amount);
		var s = json.toString();
		
		
		int statuscode = postnet.post2(s);
		
		if(statuscode == 200) {
			execution.setVariable("userAc", "true");
		}
		else {
			execution.setVariable("userAc", "false");
		}
		
	}

}
