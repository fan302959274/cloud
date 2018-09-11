package com.cloud.activiti.flow;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateTask implements TaskListener {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void notify(DelegateTask delegateTask) {
        try {
            Thread.sleep(10000);
            log.info("任务id为{}",delegateTask.getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("I am task CreateTask.");
    }
}