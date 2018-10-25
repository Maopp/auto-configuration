# auto-configuration

更新代码后，本地打包，引入工程中
<dependency>
    <groupId>com.catpp</groupId>
    <artifactId>auto-configuration</artifactId>
    <version>1.0.0</version>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-autoconfigure</artifactId>
        </exclusion>
    </exclusions>
</dependency>


使用AutoConfiguration自定义starter：
@ConfigurationProperties，该注解可以完成将application.properties配置文件内的有规则的配置参数映射到实体内的field内，不过需要提供setter方法
1、实体bean
2、业务代码
3、自定义starter自动化配置

# 相关注解说明：
@EnableConfigurationProperties：这是一个开启使用配置参数的注解，value值就是我们配置实体参数映射的ClassType，将配置实体作为配置来源。
SpringBoot内置条件注解，以下注解都是元注解@Conditional演变而来的，根据不同的条件对应创建以上的具体条件注解：
    @ConditionalOnBean：当SpringIoc容器内存在指定Bean的条件
    @ConditionalOnClass：当SpringIoc容器内存在指定Class的条件
    @ConditionalOnExpression：基于SpEL表达式作为判断条件
    @ConditionalOnJava：基于JVM版本作为判断条件
    @ConditionalOnJndi：在JNDI存在时查找指定的位置
    @ConditionalOnMissingBean：当SpringIoc容器内不存在指定Bean的条件
    @ConditionalOnMissingClass：当SpringIoc容器内不存在指定Class的条件
    @ConditionalOnNotWebApplication：当前项目不是Web项目的条件
    @ConditionalOnProperty：指定的属性是否有指定的值
    @ConditionalOnResource：类路径是否有指定的值
    @ConditionalOnSingleCandidate：当指定Bean在SpringIoc容器内只有一个，或者虽然有多个但是指定首选的Bean
    @ConditionalOnWebApplication：当前项目是Web项目的条件