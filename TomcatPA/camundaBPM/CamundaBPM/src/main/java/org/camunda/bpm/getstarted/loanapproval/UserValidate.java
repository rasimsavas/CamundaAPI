package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.getstarted.request.RequestDotnet;


import camundajar.impl.com.google.gson.JsonObject;

public class UserValidate implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		execution.setVariable("UserValidate", "false");
		Object tc =  execution.getVariable("KEYINPUTTC");
		Object password =  execution.getVariable("KEYINPUTPASS");
		
		JsonObject json = new JsonObject();
		
		
		json.addProperty("TC", tc.toString());
		json.addProperty("amount", password.toString());
		String body = json.toString();
		
		
		int statuscode = RequestDotnet.postJson(body);
		System.out.println(statuscode);
		System.out.println(execution.getVariable("UserValidate"));
		
		if(statuscode == 200) {
			execution.setVariable("UserValidate", true);
		}
		else {
			execution.setVariable("UserValidate", false);
		}
		
	}

}
