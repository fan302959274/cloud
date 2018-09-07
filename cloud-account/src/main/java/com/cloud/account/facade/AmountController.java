package com.cloud.account.facade;
/**
 * Created by sh00859 on 2018/5/22.
 */

import com.cloud.account.model.TblAccount;
import com.cloud.account.service.AmountService;
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
 * amount控制类
 *
 * @author
 * @create 2018-05-22 13:56
 **/
@RestController
@RequestMapping("/amount")
public class AmountController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private AmountService amountService;

    /**
     * @description 测试
     * @author sh00859
     * @date 2018/5/14
     */
    @RequestMapping("/operate")
    @ResponseBody
    public CommonResp<TblAccount> operate(@RequestParam(value = "orderNo", required = true) String orderNo,@RequestParam(value = "accountNo", required = true) String accountNo, @RequestParam(value = "amount", required = true) BigDecimal amount) {
        return amountService.operateAmount(orderNo,accountNo, amount);
    }


}