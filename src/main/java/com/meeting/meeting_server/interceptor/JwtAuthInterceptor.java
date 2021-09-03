package com.meeting.meeting_server.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.meeting.meeting_server.utils.TokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author zcw
 */
public class JwtAuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        JSONObject res = new JSONObject();
        PrintWriter out = null;
        if ("null".equals(token)||"".equals(token)){
            System.out.println("without token!");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            out = response.getWriter();
            res.put("code",402);
            res.put("msg","without token!");
            out.append(res.toString());
            return false;
        }else{
            try{
                //验证是否不正确，不正确会抛出异常
                System.out.println(token);
                TokenUtil.verifierToken(token);
                return true;
            }catch (Exception e){
                try {
                    TokenUtil.verifierOJToken(token);
                    return true;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("invalid token!");
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("application/json;charset=UTF-8");
                    out = response.getWriter();
                    res.put("code",402);
                    res.put("msg","invalid token!");
                    out.append(res.toString());
                    return false;
                }

            }
        }

    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
