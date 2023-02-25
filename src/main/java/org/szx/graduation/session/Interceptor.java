package org.szx.graduation.session;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.szx.graduation.model.UserLoginInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 取得 HttpSession 对象
        HttpSession session = request.getSession();
        // 读取登录信息
        UserLoginInfo userLoginInfo = (UserLoginInfo)session.getAttribute("userLoginInfo");
        if (userLoginInfo==null) {
            // 未登录
            String ar="/szx/login";
            response.sendRedirect(ar);
            return false;
        } else {
            // 已登录
            return true;
        }
    }
}
