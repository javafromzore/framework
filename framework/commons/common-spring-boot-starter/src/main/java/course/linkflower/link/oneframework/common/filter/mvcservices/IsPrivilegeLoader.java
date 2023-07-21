package course.linkflower.link.oneframework.common.filter.mvcservices;

import org.springframework.context.ApplicationContext;

import javax.servlet.http.HttpServletRequest;

public interface IsPrivilegeLoader {
    Boolean isPrivilege(ApplicationContext applicationContext, HttpServletRequest request);
}
