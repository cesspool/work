package web;

import conf.CoreConfiguration;
import conf.WebConfiguration;
import org.springframework.lang.Nullable;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;



public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{CoreConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    
    @Nullable
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter charFilter = new CharacterEncodingFilter("UTF-8", true, true);
        return new Filter[]{charFilter};
    }

}
