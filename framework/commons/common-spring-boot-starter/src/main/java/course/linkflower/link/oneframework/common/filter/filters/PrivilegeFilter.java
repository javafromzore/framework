package course.linkflower.link.oneframework.common.filter.filters;

import course.linkflower.link.oneframework.common.filter.mvcservices.IsPrivilegeLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.ApplicationContext;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ConditionalOnClass(Filter.class)
public class PrivilegeFilter extends OncePerRequestFilter {
    @Autowired
    IsPrivilegeLoader isPrivilegeLoader;
    @Autowired
    ApplicationContext applicationContext;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (isPrivilegeLoader.isPrivilege(applicationContext,request)){
            filterChain.doFilter(request, response);
        }
        response.setStatus(401);
    }
}
