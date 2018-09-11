package com.cloud.activiti.flow;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceTask1 implements JavaDelegate {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Thread.sleep(1000);
        log.info("variavles=" + execution.getVariables());
        execution.setVariable("task1", "I am task 1");
        execution.setVariable("pass", true);
        log.info("I am task 1.");

//        Map<String, Object> variables = new HashMap<String, Object>();
//        variables.put("money", 800);
//        processEngine.getTaskService()//
//                .complete(taskId,variables);
    }
}  