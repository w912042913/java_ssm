package com.neusoft.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
//spring全配置注解
//ComponentScan作用：指定spring创建容器时要扫的包
//属性：value和basePackages一样，
//等价于xml中配置context中的component——scan

//Bean
//作用：把当前方法的返回值作为Bean对象存入spring的ioc中
//属性 name指定bean的id 不写时 默认值是方法名
//细节：当我们使用注解配置时，如果说方法有参数，
// spring框架去容器中查找有没有可用的bean对象 查找的方式和auto的注解的作用是一样的

//Import 导入配置类
// 属性 配置类的字节码文件
// 当我们使用@Import 注解的类就是SpringConfiguration就是父类配置，而导入的都是子类配置类JdbcConfig
//PropertySource
// 指定properties文件的位置
//属性 文件的名称和路径   classpath 表示类路径下
@ComponentScan("com.neusoft")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {
}
