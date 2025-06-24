package org.example.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KnifeConfiguration {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("智能x光片影像分析API接口文档").version("1.0").description("系统接口文档")
        );
    }
    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder().group("原始x光片分割结果保存组件").pathsToMatch("/apart").build();
    }
    @Bean
    public GroupedOpenApi groupedOpenApi2() {
        return GroupedOpenApi.builder().group("原始x光片诊断结果保存组件").pathsToMatch("/diagnose").build();
    }
    @Bean
    public GroupedOpenApi groupedOpenApi3() {
        return GroupedOpenApi.builder().group("历史记录查询").pathsToMatch("/history/**").build();
    }

}
