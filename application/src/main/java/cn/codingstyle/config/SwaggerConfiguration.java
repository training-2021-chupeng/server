package cn.codingstyle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Profile("!prod")
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    /**
     * 创建获取api应用
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.codingstyle"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 配置swagger文档显示的相关内容标识(信息会显示到swagger页面)
     * @return
     */
    private ApiInfo apiInfo() {
        Contact contact = new Contact("codingstyle", "", "codingstyle.com");
        return new ApiInfo(
                "test",
                "test开放的接口",
                "v1.0",
                "",
                contact,
                "",
                "",
                new ArrayList<>()
        );
    }
}
