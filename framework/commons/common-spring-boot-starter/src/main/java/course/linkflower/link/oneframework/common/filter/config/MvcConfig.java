package course.linkflower.link.oneframework.common.filter.config;

import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.filter.interceptors.LoginInterceptor;
import course.linkflower.link.oneframework.common.filter.interceptors.PrivilegeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(privilegeInterceptor()).addPathPatterns("/**").order(3);
        registry.addInterceptor(loginInterceptor()).order(1);
    }
    @Bean
    public LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }
    @Bean
    public PrivilegeInterceptor privilegeInterceptor(){
        return new PrivilegeInterceptor();
    }
}