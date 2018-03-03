package web;

import conf.WebConfiguration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class FormServletInitializer implements ServletContainerInitializer{
    private static final String SERVLET_MAPPING = "/";
    
    @Override
    public void onStartup(Set<Class<?>> cls, ServletContext ctx) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(WebConfiguration.class);
        
        DispatcherServlet dispServlet = new DispatcherServlet(appContext);
        
        ServletRegistration.Dynamic formServletRegistration = ctx.addServlet("formServlet", dispServlet);
        formServletRegistration.setLoadOnStartup(1);
        formServletRegistration.addMapping(SERVLET_MAPPING); 
    }

}
