package com.example.workflow;
import org.json.*;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;


public class EndExecutionListener implements ExecutionListener{

	public static String Uri = "https://localhost:7292/api/user"; 
	public static String getUri() {
		return Uri;
	}
	
	
	
	@Override
	public void notify(DelegateExecution execution) throws Exception {
		
		
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		IdentityService identityService = processEngine.getIdentityService();
		String user = identityService.getCurrentAuthentication().getUserId();
		
		JSONObject json = new JSONObject();
		
		
		String processInstance = execution.getProcessInstanceId();
		String activityName = execution.getCurrentActivityName();
		String activityId = execution.getCurrentActivityId();
		String activityInstanceId = execution.getActivityInstanceId();
		String eventName = execution.getEventName();
		
		json.append("User", user);
		json.append("eventName", eventName);
		json.append(activityName, activityId);
		json.append("processInstance", processInstance);
		json.append("activityInstanceId", activityInstanceId);
		
		postnet.post3(json.toString());
		System.out.println(json);
		
	}
}
