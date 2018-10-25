package com.catpp.autoconfiguration.customproperty;

import lombok.Setter;

/**
 * com.catpp.springbootpro.customproperty
 *
 * @Author cat_pp
 * @Date 2018/10/25
 * @Description 自定义业务实现
 */
@Setter
public class HelloService {

    /**
     * 消息内容
     */
    private String msg;

    /**
     * 是否显示消息内容
     */
    private boolean show = true;

    public String sayHello() {
        return show == true ? "hello:" + msg : "hidden";
    }
}
