package com.cloud.activiti.flow;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceTask3 implements JavaDelegate {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Thread.sleep(1000);
        log.info("variavles=" + execution.getVariables());
        execution.setVariable("task3", "I am task 3");
        log.info("I am task 3.");
    }
}  