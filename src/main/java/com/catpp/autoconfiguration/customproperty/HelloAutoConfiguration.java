package com.catpp.autoconfiguration.customproperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * com.catpp.springbootpro.customproperty
 *
 * @Author cat_pp
 * @Date 2018/10/25
 * @Description 自定义starter自动化配置
 */
// 开启配置
@Configuration
// 开启使用映射实体对象
@EnableConfigurationProperties(HelloProperties.class)
// 存在HelloService时初始化该配置类
@ConditionalOnClass(HelloService.class)
// 存在对应配置信息时初始化该配置类
@ConditionalOnProperty(
        // 存在配置前缀hello
        prefix = "hello",
        // 开启
        value = "enabled",
        // 缺失检查
        matchIfMissing = true
)
public class HelloAutoConfiguration {

    // application.properties配置文件映射前缀实体对象
    @Autowired
    private HelloProperties helloProperties;

    /**
     * 根据条件判断不存在HelloService时初始化新bean到springIoc
     * @return
     */
    // 创建HelloService实体bean
    @Bean
    // 缺失HelloService实体bean时，初始化HelloService并添加到springIoc
    @ConditionalOnMissingBean(HelloService.class)
    public HelloService helloService() {
        System.err.println(">>>The HelloService Not found, Execute Create New Bean");
        HelloService helloService = new HelloService();
        // 设置显示内容
        helloService.setMsg(helloProperties.getMsg());
        // 设置是否显示
        helloService.setShow(helloProperties.isShow());
        return helloService;
    }
}
