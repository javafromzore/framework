package course.linkflower.link.system.controller;

import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.exception.BusinessException;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.system.dto.role.SearchDto;
import course.linkflower.link.system.dto.usergroup.AddDto;
import course.linkflower.link.system.dto.usergroup.UpdateDto;
import course.linkflower.link.system.service.UserGroupService;
import course.linkflower.link.system.vo.role.RoleDetailVo;
import course.linkflower.link.system.service.RoleService;
import course.linkflower.link.system.vo.usergroup.UserGroupVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1 + "/usergroup")
@RefreshScope
public class UserGroupController {
    @Autowired
    private UserGroupService userGroupService;

    @PostMapping("/add")
    public Result<UserGroupVo> add(@RequestBody AddDto addDto) throws BusinessException {
        return Result.succeed(userGroupService.add(addDto));
    }

    @PostMapping("/getOne")
    public Result<UserGroupVo> getOne(@RequestBody IdDto idDto) throws BusinessException {
        return Result.succeed(userGroupService.getOne(idDto));
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody IdDto idDto) {
        userGroupService.delete(idDto);
        return Result.succeed();
    }

    @PostMapping("/update")
    public Result<UserGroupVo> update (@RequestBody UpdateDto updateDto) throws BusinessException{
        return Result.succeed(userGroupService.update(updateDto));
    }

    @PostMapping("/search")
    public PageResult<UserGroupVo> search(@RequestBody SearchDto searchDto) {
        return userGroupService.search(searchDto);
    }
}
