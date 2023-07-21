package course.linkflower.link.oneframework.common.model;

/**
 * @Author: e2cef
 */
public enum CodeEnum {
    SUCCESS(0),
    ERROR(1);

    private Integer code;
    CodeEnum(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
