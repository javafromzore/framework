package course.linkflower.link.oneframework.common.exception;

import course.linkflower.link.oneframework.common.model.Result;

/**
 * 业务异常
 *
 * @author xxx
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 6610083281801529147L;

    public int getCode() {
        return code;
    }

    private int code;
    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Result result) {
        super(result.getMsg());
        this.code = result.getCode();
    }


}
