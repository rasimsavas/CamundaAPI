package org.camunda.bpm.getstarted.loanapproval;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.getstarted.request.RequestDotnet;

import camundajar.impl.com.google.gson.JsonObject;


public class ProcessRequestDelegate implements JavaDelegate {

  private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

  public void execute(DelegateExecution execution) throws Exception {
    
	Object deposit = execution.getVariable("depositCash");
    Object tc = execution.getVariable("KEYINPUTTC");
    
    
    JsonObject json = new JsonObject();
	
	
	json.addProperty("TC", deposit.toString());
	json.addProperty("amount", tc.toString());
	String body = json.toString();
	
	int statuscode = RequestDotnet.postJsonDeposit(body);
	
	if(statuscode == 200) {
		
	}
	else {
		 throw new BpmnError("codeDeposit");
	}
	
}
  
  }

