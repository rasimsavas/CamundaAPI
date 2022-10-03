package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.getstarted.request.RequestDotnet;


import camundajar.impl.com.google.gson.JsonObject;

public class AmountCheck implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		execution.setVariable("AmountCheck", "true");
		Object tc =  execution.getVariable("KEYINPUTTC");
		Object amount =  execution.getVariable("amount");
		
		JsonObject json = new JsonObject();
		
		
		json.addProperty("TC", tc.toString());
		json.addProperty("amount", amount.toString());
		String body = json.toString();
		
		
		int statuscode = RequestDotnet.postJsonAmount(body);
		System.out.println(statuscode);
		System.out.println(execution.getVariable("AmountCheck"));
		
		if(statuscode == 200) {
			execution.setVariable("AmountCheck", true);
		}
		else {
			execution.setVariable("AmountCheck", false);
		}
		
	}

}