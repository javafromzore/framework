package course.linkflower.link.oneframework.service;

import course.linkflower.link.oneframework.common.exception.BusinessException;
import course.linkflower.link.oneframework.dto.user.NameDto;
import course.linkflower.link.oneframework.dto.user.PasswordDto;
import course.linkflower.link.oneframework.dto.user.SendAuthCodeDto;

import javax.servlet.ServletResponse;
import java.io.IOException;

public interface UserService {
    void sendRobotCode(ServletResponse servletResponse, String userCode) throws IOException;

    Boolean judgePassword(PasswordDto passwordDto)  throws BusinessException;

    Boolean judgeName(NameDto nameDto)  throws BusinessException;

    Boolean sendAuthCode(SendAuthCodeDto sendAuthCodeDto)  throws BusinessException;
}
