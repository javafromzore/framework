package course.linkflower.link.oneframework.zenofsword.common.utils;

import course.linkflower.link.oneframework.common.filter.mvcservices.IsPrivilegeLoader;
import course.linkflower.link.oneframework.zenofsword.common.annotation.AccessPermissions;
import course.linkflower.link.oneframework.zenofsword.common.vo.UserSessionVo;
import lombok.Data;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PrivilegeUserLoader implements IsPrivilegeLoader {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    ApplicationContext applicationContext;

    @Data
    public static class RightItem {
        private String right;
        private String rightAll;
    }

    @PostConstruct
    private void init() {
        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            Object obj = applicationContext.getBean(beanName);
            Class<?> objClz = obj.getClass();
            if (AopUtils.isAopProxy(obj)) {
                objClz= AopUtils.getTargetClass(obj);
            }
            if (objClz.isAnnotationPresent(RequestMapping.class)) {
                RequestMapping requestMapping = objClz.getAnnotation(RequestMapping.class);
                for (Method m : objClz.getDeclaredMethods()) {
                    if (m.isAnnotationPresent(AccessPermissions.class)) {
                        AccessPermissions accessPermissions = m.getAnnotation(AccessPermissions.class);
                        if (accessPermissions != null) {
                            String[] values = accessPermissions.value();
                            String[] orValues = accessPermissions.orValue();
                            Map<String, RightItem> persMap = new HashMap<>();
                            Map<String, RightItem> persOrMap = new HashMap<>();
                            for (String value : values) {
                                RightItem ri = new RightItem();
                                String[] rs = value.split(":");
                                if (rs.length == 2) {
                                    ri.setRightAll(rs[0] + ":*");
                                }
                                ri.setRight(value);
                                persMap.put(value, ri);
                            }
                            for (String orValue : orValues) {
                                RightItem ri = new RightItem();
                                String[] rs = orValue.split(":");
                                if (rs.length == 2) {
                                    ri.setRightAll(rs[0] + ":*");
                                }
                                ri.setRight(orValue);
                                persOrMap.put(orValue, ri);
                            }
                            if (m.isAnnotationPresent(PostMapping.class)) {
                                PostMapping postMapping = m.getAnnotation(PostMapping.class);
                                if (postMapping != null) {
                                    //get full path: /api/pattern/update
                                    String[] paths = postMapping.value();
                                    for (String pp : requestMapping.value()) {
                                        for (int i = 0; i < paths.length; i++) {
                                            String p = pp + paths[i];
                                            permissionValue.put(p, persMap);
                                            apiPermissionOrValue.put(p, persOrMap);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    private  Map<String, Map<String, RightItem>> permissionValue = new HashMap<>();
    private  Map<String, Map<String, RightItem>> apiPermissionOrValue = new HashMap<>();

    @Override
    public Boolean isPrivilege(ApplicationContext applicationContext, HttpServletRequest request) {

        //car.read, car.write. car.admin,  car.read + car.*
        String p = request.getServletPath();
        Map<String, RightItem> orValue = apiPermissionOrValue.get(p);
        Map<String, RightItem> andValue = permissionValue.get(request.getServletPath());
        UserSessionVo userSessionVo = SessionUserUtil.getUserSession();
        Map<String, String> userRights = null;
        if (userSessionVo != null) {
             userRights = userSessionVo.getRightsMap();
        }

        boolean isRight = false;
        if (orValue != null && orValue.size() != 0) {
            if (userRights != null) {
                for (RightItem r : orValue.values()) {
                    if (userRights.get(r.getRight()) != null) {
                        isRight = true;
                        break;
                    }
                    if (r.getRightAll() != null) {
                        if (userRights.get(r.getRightAll()) != null) {
                            isRight = true;
                            break;
                        }
                    }
                }
            }
            if (!isRight) {
                return false;
            }
        }
        if (andValue != null && andValue.size() != 0) {
            isRight = false;
            if (userRights != null) {
                isRight = true;
                // car.read, member.write
                for (RightItem r : andValue.values()) {
                    //card.read X
                    if (userRights.get(r.getRight()) != null) {
                        continue;
                    }

                    //card.* OK
                    if (r.getRightAll() != null) {
                        if (userRights.get(r.getRightAll()) != null) {
                            continue;
                        }
                    }
                    isRight = false;
                    break;
                }
            }
            if (!isRight) {
                return false;
            }
        }
        return true;
    }
}
