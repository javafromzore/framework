package course.linkflower.link.oneframework.controller;

import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.exception.BusinessException;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.dto.user.NameDto;
import course.linkflower.link.oneframework.dto.user.PasswordDto;
import course.linkflower.link.oneframework.dto.user.SendAuthCodeDto;
import course.linkflower.link.oneframework.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletResponse;
import java.io.IOException;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1 + "/user")
@RefreshScope
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("sendRobotCode")
    public void sendRobotCode(ServletResponse servletResponse,
                              @RequestParam(value = "userCode", required = true) String userCode) throws IOException {
        userService.sendRobotCode(servletResponse, userCode);
    }

    @PostMapping("/judgePassword")
    public Result<Boolean> judgePassword(@RequestBody PasswordDto passwordDto) throws BusinessException {
        return Result.succeed(userService.judgePassword(passwordDto));
    }

    @PostMapping("/judgeName")
    public Result<Boolean> judgeName(@RequestBody NameDto nameDto) throws BusinessException{
        return Result.succeed(userService.judgeName(nameDto));
    }

    @PostMapping("/sendAuthCode")
    public Result<Boolean> sendAuthCode(@RequestBody SendAuthCodeDto sendAuthCodeDto) throws BusinessException{
        return Result.succeed(userService.sendAuthCode(sendAuthCodeDto));
    }
}
