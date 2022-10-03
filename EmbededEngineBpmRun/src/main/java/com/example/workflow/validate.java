package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.json.JSONObject;

public class validate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		
		var tc = execution.getVariable("KEYINPUTTC");
		var pass = execution.getVariable("KEYINPUTPASS");
		
		JSONObject json = new JSONObject();
		json.append("TC", tc);
		json.append("PASSWORD", pass);
		var s = json.toString();
		
		int statuscode = postnet.post1(s);
		
		if (statuscode == 200) {
			var isValid = execution.getVariable("isValidp");
			
			//execution.setVariable("isValid", "true");
			//execution.setVariable("userAc", "true");
			System.out.println("ISVLID:.." + isValid);
			execution.setVariable("isValidp", "true");
			
		}
		else {
			
			execution.setVariable("isValidp","false");
			System.out.println("ISVLID:.." + execution.getVariable("isValidp"));
			
		}
		
		

	}

}
