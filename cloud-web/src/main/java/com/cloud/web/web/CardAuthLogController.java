package com.cloud.web.web;

import com.cloud.common.entity.TblAdmCardauthlog;
import com.cloud.common.req.TblAdmCardauthlogPageReq;
import com.cloud.common.resp.CommonResp;
import com.cloud.common.resp.PageResp;
import com.cloud.web.fegin.CardAuthLogFeginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


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
    private CardAuthLogFeginService cardAuthLogFeginService;

    /**
     * @description 主界面
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/main"})
    public ModelAndView search(Map map) throws Exception {
        //获取所有的视频类型
        return new ModelAndView("/cardauth/main", map);

    }


    /**
     * @description 添加界面
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/add"})
    public String add() throws Exception {
        return "/cardauth/add";
    }


    /**
     * @description 更新页面
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/edit"})
    public ModelAndView edit(TblAdmCardauthlog TblAdmCardauthlog, Map map) throws Exception {
        map.put("data", cardAuthLogFeginService.selectByKey(TblAdmCardauthlog.getId()));
        return new ModelAndView("/cardauth/edit", map);
    }


    /**
     * @description 列表数据
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/data"})
    @ResponseBody
    public PageResp<TblAdmCardauthlog> list(TblAdmCardauthlogPageReq pageReq) throws Exception {
        PageResp<TblAdmCardauthlog> resp = cardAuthLogFeginService.list(pageReq);
        return resp;
    }


    /**
     * @description 保存(此处需要将对象转换为json String类型ps:ajaxFileUpload版本太老, 重构太麻烦)
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/save"})
    @ResponseBody
    public CommonResp<TblAdmCardauthlog> save(TblAdmCardauthlog TblAdmCardauthlog) throws Exception {
        return cardAuthLogFeginService.save(TblAdmCardauthlog);
    }

    /**
     * @description 更新
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/update"})
    @ResponseBody
    public CommonResp<TblAdmCardauthlog> update(TblAdmCardauthlog TblAdmCardauthlog) throws Exception {
        return cardAuthLogFeginService.update(TblAdmCardauthlog);
    }

    /**
     * @description 删除
     * @author sh00859
     * @date 2017/9/8
     */
    @RequestMapping(value = {"/delete"})
    @ResponseBody
    public CommonResp<String> delete(String ids) throws Exception {
        return cardAuthLogFeginService.delete(ids);
    }


}
