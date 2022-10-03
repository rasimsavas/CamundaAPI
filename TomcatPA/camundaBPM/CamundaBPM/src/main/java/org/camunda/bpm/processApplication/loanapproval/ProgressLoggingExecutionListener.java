package org.camunda.bpm.getstarted.loanapproval;

import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;


public class ProgressLoggingExecutionListener implements ExecutionListener {

	  private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	  
	  // static value list to see in the UNIT test if the execution listener was executed
	  public static List<String> progressValueList = new ArrayList<String>();

	  private String propertyValue;

	  // constructor with extension property value as parameter
	  public ProgressLoggingExecutionListener(String value) {
	    this.propertyValue = value;
	  }

	  // notify method is executed when Execution Listener is called
	  public void notify(DelegateExecution execution) throws Exception {
	    progressValueList.add(propertyValue);
	    
	    // logging statement to see which value have the property 'progress'
	    LOGGER.info("value of service task extension property 'progress': " + propertyValue);
	  }
	}