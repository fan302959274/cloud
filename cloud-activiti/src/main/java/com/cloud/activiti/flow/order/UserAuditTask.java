package com.cloud.activiti.flow.order;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sh00859
 * @description 用户审核
 * @date 2018/9/11
 */
public class UserAuditTask implements TaskListener, ExecutionListener {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        log.info("审核开始notify!");
    }

    @Override
    public void notify(DelegateTask delegateTask) {
        log.info("审核开始DelegateTask!");
    }
}
