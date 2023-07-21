package course.linkflower.link.oneframework.common.filter.filters;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSONObject;
import course.linkflower.link.oneframework.common.constant.CommonConstant;
import course.linkflower.link.oneframework.common.constant.SecurityConstants;
import course.linkflower.link.oneframework.common.context.TenantContextHolder;
import course.linkflower.link.oneframework.common.exception.BusinessException;
import course.linkflower.link.oneframework.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.data.redis.core.StringRedisTemplate;
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
public class BusinessExceptionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(request, response);
        } catch (BusinessException be) {
            Result result = new Result();
            result.setCode(be.getCode());
            result.setMsg(be.getLocalizedMessage());
            response.getOutputStream().print(JSONObject.toJSONString(response));
        }
    }
}
