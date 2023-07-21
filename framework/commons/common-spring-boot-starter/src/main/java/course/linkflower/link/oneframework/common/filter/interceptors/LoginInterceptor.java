package course.linkflower.link.oneframework.common.filter.interceptors;

import course.linkflower.link.oneframework.common.filter.mvcservices.ISessionLoader;
import course.linkflower.link.oneframework.common.filter.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ISessionLoader sessionLoader;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("authorization");
        if (token != null) {
            token = token.substring(7);
            Object session = sessionLoader.loadSession(token);
            if (session != null) {
                SessionUtil.setSession(session);
            }
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
