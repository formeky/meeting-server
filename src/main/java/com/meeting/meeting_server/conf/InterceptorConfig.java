package com.meeting.meeting_server.conf;

import com.meeting.meeting_server.interceptor.JwtAuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zcw
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //定义需要拦截的路径
        String[] addPathPatterns = {
                "/**/**.do",
        };
        //定义不需要拦截的路径
        String[] excludePathPatterns = {
                "/login",
        };
        registry.addInterceptor(new JwtAuthInterceptor())
                .addPathPatterns(addPathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //文件磁盘图片url 映射
        //配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
        registry.addResourceHandler(AppConfig.getPrefix()+"/**").addResourceLocations("file:"+AppConfig.getBaseDir()+"/");
    }
}
