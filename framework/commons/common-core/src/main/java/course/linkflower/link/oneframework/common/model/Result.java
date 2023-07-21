package course.linkflower.link.oneframework.common.model;

import course.linkflower.link.oneframework.common.constant.StringsConstant;
import course.linkflower.link.oneframework.common.utils.LanguageUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: e2cef
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private T data;
    private Integer code;
    private String msg;
    private String url;

    public static <T> Result<T> succeed() {
        return of(null, CodeEnum.SUCCESS.getCode(), "success");
    }

    public static <T> Result<T> succeed(String msg) {
        return of(null, CodeEnum.SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> succeed(T model, String msg) {
        return of(model, CodeEnum.SUCCESS.getCode(), msg);
    }

    public static <T> Result<T> succeed(T model) {
        return of(model, CodeEnum.SUCCESS.getCode(), StringsConstant.Success);
    }

    public static <T> Result<T> of(T datas, Integer code, String msg) {
        return new Result<>(datas, code, msg, null);
    }

    public static <T> Result<T> failed(String msg) {
        return of(null, CodeEnum.ERROR.getCode(), msg);
    }

    public static <T> Result<T> failed(int code, String msg) {
        return of(null, code, msg);
    }

    public static <T> Result<T> failed() {
        return of(null, CodeEnum.ERROR.getCode(), LanguageUtil.get(StringsConstant.SystemError));
    }

    public static <T> Result<T> failed(T model, String msg) {
        return of(model, CodeEnum.ERROR.getCode(), msg);
    }
}
