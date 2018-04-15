package interceptor;

import form.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import web.Pages;
import web.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class PrincipalInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private HttpSession session;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod hdrMethod = (HandlerMethod)handler;
        BaseController controller = (BaseController)hdrMethod.getBean();
        Principal principal = controller.getPrincipal();
        
        if(controller.isForFree()) {
            return true;
        }
        if (principal == null) {
            response.sendRedirect(request.getContextPath() + "/loginform");
            return false;
        }
        if (controller.isForAdmin() && !principal.isAdmin()) {
            response.sendRedirect(request.getContextPath() + "/" + Pages.NO_ACCESS);
            return false;
        }
        if (controller.isForManager() && !principal.isManager() && !principal.isAdmin()) {
            response.sendRedirect(request.getContextPath() + "/" + Pages.NO_ACCESS);
            return false;
        }

        return true;
    }

    
}
