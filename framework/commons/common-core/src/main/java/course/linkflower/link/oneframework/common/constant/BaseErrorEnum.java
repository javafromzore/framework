package course.linkflower.link.oneframework.common.constant;

import static course.linkflower.link.oneframework.common.constant.BaseErrorContst.BaseErrorBase;

public enum BaseErrorEnum {

    FalseNameFormatError(BaseErrorBase + 10, "%格式不符合要求，请按照提示输入正确用户名:%s"),
    TimeParamError(1, "参数错误:%s"),

    TimeParamDuplicate(BaseErrorBase+3,"参数重复错误:%s"),
    NotExist(BaseErrorBase + 21,"参数不存在:%s"),

    NoRightPhoneNum(BaseErrorBase + 5, "%请填写正确的手机号:%s"),
    FalsePwdFormat(BaseErrorBase + 8,"\"%密码长度为8-16位，且不能是相同或连续字符:%s\""),

    NameExist(BaseErrorBase + 13, "%用户名重复:%s"),
    PhoneExistError(BaseErrorBase + 14,"%该手机已注册:%s"),
    EmailFormatError(BaseErrorBase + 6, "%邮箱格式不正确:%s"),
    EmailExistError(BaseErrorBase + 15, "%该邮箱已注册:%s"),
    FalseRobotCode(BaseErrorBase +24, "人机码错误:%s"),
    NoVerifyError(BaseErrorBase + 17,"请您先进行验证");


    private int code;
    private String message;
    BaseErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
