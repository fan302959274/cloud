package com.cloud.core.facade;

import com.cloud.common.req.TblAdmCardauthlogPageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.common.resp.PageResp;
import com.cloud.core.model.TblAdmCardauthlog;
import com.cloud.core.service.CardAuthLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author sh00859
 * @description 实例代码
 * @date 2017/8/21
 */
@Controller
@RequestMapping("/cardauth")
public class CardAuthLogController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CardAuthLogService cardAuthLogService;


    /**
     * @description 获取参数
     * @author sh00859
     * @date 2017/7/13
     */
    @RequestMapping(value = {"/get"})
    @ResponseBody
    public TblAdmCardauthlog selectByKey(@RequestParam(value = "id") Long id) {
        return cardAuthLogService.selectByKey(id);
    }

    /**
     * @description 列表数据
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/data"})
    @ResponseBody
    public PageResp<TblAdmCardauthlog> list(@RequestBody TblAdmCardauthlogPageReq pageReq) throws Exception {
        PageResp<TblAdmCardauthlog> resp = cardAuthLogService.selectListByPage(pageReq);
        return resp;
    }

    /**
     * @description 保存(此处需要将对象转换为json String类型ps:ajaxFileUpload版本太老, 重构太麻烦)
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/save"})
    @ResponseBody
    public CommonResp<TblAdmCardauthlog> save(@RequestBody TblAdmCardauthlog TblAdmCardauthlog) throws Exception {
        return cardAuthLogService.save(TblAdmCardauthlog);
    }

    /**
     * @description 更新
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/update"})
    @ResponseBody
    public CommonResp<TblAdmCardauthlog> update(@RequestBody TblAdmCardauthlog TblAdmCardauthlog) throws Exception {
        return cardAuthLogService.update(TblAdmCardauthlog);
    }

    /**
     * @description 删除
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/delete"})
    @ResponseBody
    public CommonResp<String> delete(@RequestParam(value = "ids") String ids) throws Exception {
        return cardAuthLogService.delete(ids);
    }


}
