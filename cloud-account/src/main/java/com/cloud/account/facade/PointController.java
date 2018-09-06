package com.cloud.account.facade;
/**
 * Created by sh00859 on 2018/5/22.
 */

import com.cloud.account.model.TblAccount;
import com.cloud.account.service.PointService;
import com.cloud.common.resp.CommonResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * point控制类
 *
 * @author
 * @create 2018-05-22 13:56
 **/
@RestController
@RequestMapping("/point")
public class PointController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private PointService pointService;

    /**
     * @description 测试
     * @author sh00859
     * @date 2018/5/14
     */
    @RequestMapping("/operate")
    @ResponseBody
    public CommonResp<TblAccount> operate(@RequestParam(value = "accountNo", required = true) String accountNo, @RequestParam(value = "point", required = true) BigDecimal point) {
        return pointService.operatePoint(accountNo, point);
    }


}