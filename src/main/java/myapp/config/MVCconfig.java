package myapp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Конфигурация для перехвата feign запросов (ничего не делает просто пример)
 */
@Configuration
@RequiredArgsConstructor
public class MVCconfig implements WebMvcConfigurer {

    private final MyInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/mycontr/feign");
    }

}
