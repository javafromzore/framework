package course.linkflower.link.oneframework.common.filter.filters;

import course.linkflower.link.oneframework.common.filter.mvcservices.ISessionLoader;
import course.linkflower.link.oneframework.common.filter.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 租户过滤器
 *
 * @author xxx
 * @date 2019/9/15
 */
@ConditionalOnClass(Filter.class)
public class SessionFilter extends OncePerRequestFilter {

    @Autowired
    private ISessionLoader sessionLoader;

    @Order(value = 1)
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {
        String token = request.getHeader("authorization");
        if (token != null) {
            Object session = sessionLoader.loadSession(token);
            if (session != null) {
                SessionUtil.setSession(session);
            }
        }
//        response.setStatus(401);
        filterChain.doFilter(request, response);
    }
}
