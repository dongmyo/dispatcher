package com.nhnent.dispatcher;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String id = (String) request.getSession().getAttribute("id");
        if(id == null || id.length() == 0) {
            response.sendRedirect("/login");
            return false;
        }

        return super.preHandle(request, response, handler);
    }

}
