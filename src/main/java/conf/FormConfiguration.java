package conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("form")
public class FormConfiguration {
    private final static String PAGE_PREFIX = "/WEB-INF/pages/";
    private final static String PAGE_SUFFIX = ".jspx";
    
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver(PAGE_PREFIX, PAGE_SUFFIX);
        return viewResolver;
    }
}
