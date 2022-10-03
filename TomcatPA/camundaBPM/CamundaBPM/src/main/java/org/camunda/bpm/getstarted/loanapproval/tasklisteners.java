package org.camunda.bpm.getstarted.loanapproval;

import java.util.List;

import org.camunda.bpm.engine.CaseService;
import org.camunda.bpm.engine.ExternalTaskService;
import org.camunda.bpm.engine.FilterService;
import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;


public class tasklisteners implements TaskListener{

	@Override
	public void notify(DelegateTask delegateTask) {
		
		
		/*
		System.out.println("PROCESS INSTANCE ID:.."+ delegateTask.getProcessInstanceId());
		System.out.println("GET ID:.."+delegateTask.getId());
		System.out.println("PROCESS ENGINE:.."+delegateTask.getProcessEngine().getName());
		
		ProcessEngine processEngine = ProcessEngines.getProcessEngine("default2");
		
		
		RepositoryService repositoryService = processEngine.getRepositoryService();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		TaskService taskService = processEngine.getTaskService();
		IdentityService identityService = processEngine.getIdentityService();
		FormService formService = processEngine.getFormService();
		HistoryService historyService = processEngine.getHistoryService();
		ManagementService managementService = processEngine.getManagementService();
		FilterService filterService = processEngine.getFilterService();
		ExternalTaskService externalTaskService = processEngine.getExternalTaskService();
		CaseService caseService = processEngine.getCaseService();
		org.camunda.bpm.engine.DecisionService decisionService = processEngine.getDecisionService();
		
		// AuthorizationException - if the user has no Permissions.UPDATE permission on Resources.PROCESS_INSTANCE or no Permissions.UPDATE_INSTANCE permission on Resources.PROCESS_DEFINITION.
		// definitinon id ye gore islerin aktif deaktif edilmesi
		//managementService.updateJobSuspensionState().byJobDefinitionId("ID").activate();
		
		// XML tarafindan tanimlanmis bir oncelik parametresini run time esnasinda degistirdiysek, asagidaki method ile priority parametresini default yani XML dosyasindaki haline geri getiriyoruz
		//managementService.clearOverridingJobPriorityForJobDefinition("jobDefinitionId");
		
		// hali hazirda pool da bulunan islerin listesini alir, 
		//List<?> asd = runtimeService.createExecutionQuery().list();
		
		*/
		
		
		
		
	}

}
