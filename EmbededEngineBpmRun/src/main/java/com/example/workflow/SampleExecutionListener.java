package com.example.workflow;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.json.JSONObject;


public class SampleExecutionListener implements ExecutionListener {
	
	@Override
	public void notify(DelegateExecution execution) throws Exception {
		System.out.println("Sample Execution executed");
		
		
		/* 
		
		HistoryService historyService = processEngine.getHistoryService();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		TaskService taskService = processEngine.getTaskService();
		IdentityService identityService = processEngine.getIdentityService();
		FormService formService = processEngine.getFormService();
		ManagementService managementService = processEngine.getManagementService();
		FilterService filterService = processEngine.getFilterService();
		ExternalTaskService externalTaskService = processEngine.getExternalTaskService();
		CaseService caseService = processEngine.getCaseService();
		DecisionService decisionService = processEngine.getDecisionService();
		*/
		
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		IdentityService identityService = processEngine.getIdentityService();
		JSONObject json = new JSONObject();
		
		String user = identityService.getCurrentAuthentication().getUserId();
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
		
		
		
		/*List<ProcessInstance> process = runtimeService2.createProcessInstanceQuery().list();
		List<HistoricDetail> historicDetails = historyService.createHistoricDetailQuery().list();
		List<HistoricProcessInstance> processInstance = historyService.createHistoricProcessInstanceQuery().list();
	   /* for (ProcessInstance processInstance : process) {
	    	System.out.println("Process ID : " + processInstance.getId());
		}
		
		for (HistoricDetail item : historicDetails) {
	    	System.out.println("Time : " + item.getTime().toString());
	    	System.out.println("------------------------------");
	    	System.out.println("Time : " + item.getId());
	    	System.out.println("------------------------------");
		}*/
		
		
		
		/*for (HistoricProcessInstance item : processInstance) {
    	System.out.println("User : " + item.getStartUserId());
    	System.out.println("Start Time : " + item.getStartTime());
    	System.out.println("------------------------------");
		}*/
		
		postnet.post3(json.toString());
		System.out.println(json);
		//System.out.println("JOBLOGQUERY[0]:.."+ historyService.createHistoricJobLogQuery().list().get(0).getId());
		
		
		
		

		
	}

}
