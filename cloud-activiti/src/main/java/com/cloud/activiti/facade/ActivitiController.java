package com.cloud.activiti.facade;

import com.cloud.common.resp.CommonResp;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


/**
 * @author sh00859
 * @description 实例代码
 * @date 2017/8/21
 */
@Controller
@RequestMapping("/activiti")
public class ActivitiController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    ProcessEngine engineEngine;//注入流程引擎

    /**
     * @description 获取流程实例id
     * @author sh00859
     * @date 2017/7/13
     */
    @RequestMapping(value = {"/getInstanceId"})
    @ResponseBody
    public CommonResp<String> getBusinessId(@RequestParam(value = "instanceByKey", required = true) String instanceByKey) {
        CommonResp<String> resp = new CommonResp<>();
        ProcessInstance pi = engineEngine.getRuntimeService().startProcessInstanceByKey(instanceByKey);
        resp.setResult(pi.getId());
        return resp;
    }

    /**
     * @description 部署流程
     * @author sh00859
     * @date 2017/7/13
     */
    @RequestMapping(value = {"/deployFlow"})
    @ResponseBody
    public CommonResp<String> deploymentFlow(@RequestParam(value = "bpmnName", required = true) String bpmnName) {
        CommonResp<String> resp = new CommonResp<>();
        DeploymentBuilder builder = engineEngine.getRepositoryService().createDeployment();
        String deployId = builder.addClasspathResource(bpmnName).deploy().getId();
        logger.info("流程部署完成\n" + deployId);
        resp.setResult(deployId);
        return resp;
    }


}
