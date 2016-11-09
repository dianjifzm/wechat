package com.yilan.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * User: Archer
 * Date: 14-2-11
 * Time: 下午6:53
 * Des: 抽象类，用于绑定String字符串过滤，需要做安全字符串过滤的请继承该Controller
 */
@Controller
public abstract class SecureController {

    /**
     * 绑定该控制器对所有的String类型做安全字符串的转换
     * @param binder  WebDataBinder数据绑定对象
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new SecureStringEditor(true, true, true));
    }
}
