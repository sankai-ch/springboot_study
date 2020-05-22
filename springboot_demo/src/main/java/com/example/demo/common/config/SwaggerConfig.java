package com.example.demo.common.config;

import com.example.demo.common.core.CommonRequestData;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SanKai
 * @since 2019-11-05
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

//    @Value(value = "${spring.swagger2.enabled}")
//    private Boolean swaggerEnabled;

    @Bean
    public Docket restfulApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("x-auth-token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        //初始化公共header参数
        Arrays.asList(FieldUtils.getAllFields(CommonRequestData.class)).forEach(
                item -> {
                    ApiModelProperty annotation = item.getAnnotation(ApiModelProperty.class);
                    if (annotation != null) {
                        pars.add(new ParameterBuilder()
                                .name(CommonRequestData.HEADER_PREFIX + item.getName())
                                .description(annotation.value())
                                .modelRef(new ModelRef(annotation.dataType())).parameterType("header")
                                .required(false).hidden(true).defaultValue(annotation.example()).build());
                    }
                });
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("RestfulApi")
                .globalOperationParameters(pars)
                .apiInfo(initInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo initInfo() {
        return new ApiInfoBuilder()
                .title("Swagger！Restful API")
                .description("搭建Swagger")
                .termsOfServiceUrl("https://study.162.com/provider/1016671292/index.htm")
                .version("1.0")
                .build();
    }
}
