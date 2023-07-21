package course.linkflower.link.oneframework.zenofsword.common.utils;

import course.linkflower.link.oneframework.common.filter.utils.SessionUtil;
import course.linkflower.link.oneframework.zenofsword.common.vo.UserSessionVo;

public class SessionUserUtil {
    public static UserSessionVo getUserSession() {
        return (UserSessionVo)SessionUtil.getSession();
    }
}
