package com.hand;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Created by fei.tang@hand-china.com on 2018/1/17.
 * @description 内容交易平台
 */
@Configuration
@EnableSwagger2  //启动swagger2
public class Swagger2Config {

    //创建API基本信息
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 扫描该包下的所有需要在Swagger中展示的API，@ApiIgnore注解标注的除外
                .apis(RequestHandlerSelectors.basePackage("com.hand"))
                .paths(PathSelectors.any())
                .build();
    }

    //创建API的基本信息，这些信息会在Swagger UI中进行显示
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建Restful API") //API标题
                .description("Spring Cloud搭建的生产者的Restful API") //API描述
                .contact("fei.tang@hand-china.com") //联系人
                .version("1.0") //版本号
                .build();
    }
}