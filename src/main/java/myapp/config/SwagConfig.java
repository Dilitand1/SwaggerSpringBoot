package myapp.config;

import myapp.listComponents.IListClass;
import myapp.listComponents.MainClassComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * В текущей версии данный конфиг не требуется
 */
@Configuration
@EnableSwagger2
@ComponentScan("myapp")
public class SwagConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * Пример создания бина MainClassComponent который нигде не объявлен и насечивания List всеми интерфейсами IListClass
     * @param classComponent
     * @return
     */
    @Bean("list")
    public List<IListClass> getList(MainClassComponent classComponent) {
        return classComponent.getMyList();
    }
}
