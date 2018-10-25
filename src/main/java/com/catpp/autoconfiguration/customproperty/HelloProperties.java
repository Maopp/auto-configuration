package com.catpp.autoconfiguration.customproperty;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * com.catpp.springbootpro.customproperty
 *
 * @Author cat_pp
 * @Date 2018/10/25
 * @Description 配置文件实体映射
 *
 * \@ConfigurationProperties，
 * 该注解可以完成将application.properties配置文件内的有规则的配置参数映射到实体内的field内，不过需要提供setter方法
 */
@Data
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {

    /**
     * 消息内容
     */
    private String msg = "catpp";

    /**
     * 是否显示消息内容
     */
    private boolean show = true;
}
