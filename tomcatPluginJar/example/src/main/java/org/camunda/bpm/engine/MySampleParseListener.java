package org.camunda.bpm.engine;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.camunda.bpm.engine.impl.bpmn.parser.AbstractBpmnParseListener;
import org.camunda.bpm.engine.impl.bpmn.parser.BpmnParseListener;
import org.camunda.bpm.engine.impl.pvm.delegate.ActivityBehavior;
import org.camunda.bpm.engine.impl.pvm.process.ActivityImpl;
import org.camunda.bpm.engine.impl.pvm.process.ScopeImpl;
import org.camunda.bpm.engine.impl.util.xml.Element;

public class MySampleParseListener extends AbstractBpmnParseListener implements BpmnParseListener {

  private final Logger LOGGER = Logger.getLogger(MySampleParseListener.class.getName());
  

  @Override
  public void parseStartEvent(Element startEventElement, ScopeImpl scope, ActivityImpl startEvent) {
    LOGGER.info("Parsing Start Event "
        + "/n activityId="  + startEvent.getId()
        + "/n activityName='" + startEvent.getName() + "'"
        + "/n getActivityID " + startEvent.getActivityId()
        + "/n scopeId= " + scope.getId()
        + "/n Listeners= " + scope.getListeners().keySet().toString()
        + "/n scopeName= " + scope.getName());
    	
    
    
  }

  @Override
  public void parseUserTask(Element userTaskElement, ScopeImpl scope, ActivityImpl activity) {
    LOGGER.info("Adding Task Listener to User Task:/n"
        + " activityId=" + activity.getId()
        + "/n activityName='" + activity.getName() + "'"
        + "/n scopeId=" + scope.getId()
        + "/n scopeName=" + scope.getName());
    
    
    ActivityBehavior behavior = activity.getActivityBehavior();
    if (behavior instanceof UserTaskActivityBehavior) {
      ((UserTaskActivityBehavior) behavior).getTaskDefinition().addTaskListener(TaskListener.EVENTNAME_CREATE,  new MySampleTaskListener());
    }
  }

}
