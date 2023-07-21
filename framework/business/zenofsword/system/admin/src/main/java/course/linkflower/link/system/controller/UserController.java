package course.linkflower.link.system.controller;

import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.exception.BusinessException;
import course.linkflower.link.oneframework.common.model.Result;
//import course.linkflower.link.system.dto.user.NameDto;
//import course.linkflower.link.system.dto.user.PasswordDto;
import course.linkflower.link.system.service.UserService;
import course.linkflower.link.system.vo.privilege.CodeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1 + "/user")
@RefreshScope
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/privilege")
    public Result<List<CodeVo>> privilege(@RequestBody IdDto idDto){
        return Result.succeed(userService.privilege(idDto));
    }

    @PostMapping("/getUserRights")
    public Result<Map<String, String>> getUserRights(@RequestParam("userId") long userId){
        return Result.succeed(userService.getUserRights(userId));
    }
}
