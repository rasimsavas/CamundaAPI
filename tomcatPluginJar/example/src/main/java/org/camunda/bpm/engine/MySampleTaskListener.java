package org.camunda.bpm.engine;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

public class MySampleTaskListener implements TaskListener {

  private final Logger LOGGER = Logger.getLogger(MySampleTaskListener.class.getName());

  @Override
  public void notify(DelegateTask task) {
    LOGGER.info("Event '" + task.getEventName() + "' received by Task Listener for Task: /n"
        + " activityId=" + task.getTaskDefinitionKey()
        + "/n name='" + task.getName() + "'"
        + "/n taskId=" + task.getId()
        + "/n assignee='" + task.getAssignee() + "'"
        + "/n candidateGroups='" + task.getCandidates() + "'"
        + "/n executionID= " + task.getExecutionId()
        + "/n Priority" + task.getPriority());
  }

}
