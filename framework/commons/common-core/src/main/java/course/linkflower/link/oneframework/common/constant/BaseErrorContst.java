package course.linkflower.link.oneframework.common.constant;

public class BaseErrorContst {
    public final static int BaseErrorBase = 0;

    public final static int BaseErrorTimeFormatError = BaseErrorBase + 1;
    public final static String BaseMsgTimeFormatError = "时间格式错误";


    public final static int BaseErrorTimeParamError = BaseErrorBase + 2;
    public final static String BaseMsgTimeParamsError = "参数错误:%s";


    public final static int BaseErrorTimeParamDuplicateError = BaseErrorBase + 3;
    public final static String BaseMsgTimeParamsDuplicateError = "参数重复错误:%s";

    public final static int BaseErrorClientNoChooseError = BaseErrorBase + 4;
    public final static String BaseMsgClientNoChooseError = "%用户未选择:%s";

    public final static int BaseErrorNoPhoneNumError = BaseErrorBase + 9;
    public final static String BaseMsgNoPhoneNumError = "%请输入手机号:%s";

    public final static int BaseErrorNoRightPhoneNumError = BaseErrorBase + 5;
    public final static String BaseMsgNoRightPhoneNumError = "%请填写正确的手机号:%s";

    public final static int BaseErrorFalseVerificationCodeError = BaseErrorBase + 6;
    public final static int BaseErrorFalsePwdFormatError = BaseErrorBase + 7;

    public final static String BaseMsgFalsePwdFormatError = "%密码长度为8-16位，且不能是相同或连续字符:%s";
    public final static int BaseErrorFalsePwdRepeatError = BaseErrorBase + 8;

    public final static String BaseMsgFalsePwdCRepeatError = "%两次输入密码不一致:%s";
    public final static int BaseErrorFalseNameFormatError = BaseErrorBase + 10;

    public final static String BaseMsgFalseNameFormatError = "%格式不符合要求，请按照提示输入正确用户名:%s";
    public final static int BaseErrorFalseCheckCodeError = BaseErrorBase + 11;

    public final static int BaseErrorFalseCheckCodeAndPhoneError = BaseErrorBase + 12;
    public final static String BaseMsgFalseCheckCodeAndPhoneError = "%请输入正确的人机码或手机号:%s";

    public final static int BaseErrorNameExistError = BaseErrorBase + 13;
    public final static String BaseMsgNameExistError = "%用户名重复:%s";

    public final static int BaseErrorPhoneExistError = BaseErrorBase + 14;
    public final static String BaseMsgPhoneExistError = "%该手机已注册:%s";

    public final static int BaseErrorEmailExitError = BaseErrorBase + 15;
    public final static String BaseMsgEmailExitError = "%该邮箱已注册:%s";

    public final static int BaseErrorEmailFormatError = BaseErrorBase + 16;
    public final static String BaseMsgEmailFormatError = "%邮箱格式不正确:%s";

    public final static int BaseErrorNoVerifyError = BaseErrorBase + 17;
    public final static String BaseMsgNoVerifyError = "%请您先进行验证:%s";

    public final static int BaseErrorPasswordError = BaseErrorBase + 18;
    public final static String BaseMsgPasswordError = "%密码错误，请重试:%s";

    public final static int BaseErrorNoEmailError = BaseErrorBase + 19;
    public final static String BaseMsgNoEmailError = "%邮箱未注册:%s";

    public final static int BaseErrorNoPhoneError = BaseErrorBase + 20;
    public final static String BaseMsgNoPhoneError = "%手机号未注册:%s";


    public final static int BaseErrorNotExistError = BaseErrorBase + 21;

    public final static String BaseMsgNotExistError = "参数不存在:%s";

    public final static int BaseErrorTimeParamMaxError = BaseErrorBase + 22;
    public final static String BaseMsgTimeParamsMaxError = "%参数不能大于:%s";

    public final static int BaseErrorTimeParamnotEnteredError = BaseErrorBase + 23;
    public final static String BaseMsgTimeParamnotEnteredError = "%参数未输入:%s";

    public final static int BaseErrorFalseRobotCodeError = BaseErrorBase + 24;
    public final static String BaseMsgErrorFalseRobotCodeError = "人机码错误:%s";

}
