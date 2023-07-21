package course.linkflower.link.oneframework.consts;

import lombok.Data;

@Data
public class RegexConst {
    /**
     * 手机号正则
     */
    public static final String PHONE_REGEX = "^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$";
    /**
     * 邮箱正则
     */
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    /**
     * 用户名正则
     */
    public static final String USERNAME_REGEX = "^[a-zA-Z0-9_-]{4,20}$";
    /**
     * 密码正则。8-16位的字母、数字、下划线
     */
    public static final String PASSWORD_REGEX = "^\\w{8,16}$";
}
