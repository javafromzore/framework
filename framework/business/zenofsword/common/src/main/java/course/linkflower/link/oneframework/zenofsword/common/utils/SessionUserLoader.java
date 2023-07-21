package course.linkflower.link.oneframework.zenofsword.common.utils;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson2.JSONObject;
import course.linkflower.link.oneframework.common.filter.mvcservices.ISessionLoader;
import course.linkflower.link.oneframework.zenofsword.common.constant.RedisConstant;
import course.linkflower.link.oneframework.zenofsword.common.vo.UserSessionVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class SessionUserLoader implements ISessionLoader {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public Object loadSession(String token) {
        try {
            String key = RedisConstant.loginToken + token;
            String body = stringRedisTemplate.opsForValue().get(key);
            if (body != null) {
                UserSessionVo userSessionVo = JSONObject.parseObject(body, UserSessionVo.class);
                stringRedisTemplate.expire(key,30, TimeUnit.MINUTES);
                key = RedisConstant.permissionToken + token;
                String value = stringRedisTemplate.opsForValue().get(key);
                if (!StringUtils.isEmpty(value)) {
                    Map userRights = JSONObject.parseObject(value, Map.class);
                    userSessionVo.setRightsMap(userRights);
                    stringRedisTemplate.expire(key,30, TimeUnit.MINUTES);
                }
                return userSessionVo;
            }
        } catch (Exception e) {
        }
        return null;
    }

}
