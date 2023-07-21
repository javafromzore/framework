package course.linkflower.link.oneframework.common.filter;

import course.linkflower.link.oneframework.common.model.Result;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.web.filter.OncePerRequestFilter;
import cn.hutool.json.JSONUtil;

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
public class CatchFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(request, response);
        } catch (Exception e){
            Result r = Result.failed();
            response.getWriter().write(JSONUtil.toJsonStr(r));
        }
    }
}
