package com.cloud.activiti.flow;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.TaskListener;

public class HelloWorld implements TaskListener, ExecutionListener {


    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Hello world delegateExecution!");
    }

    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("Hello world DelegateTask!");
    }
}
