package course.linkflower.link.system.controller;

import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.exception.BusinessException;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.system.dto.role.AddDto;
import course.linkflower.link.system.dto.role.SearchDto;
import course.linkflower.link.system.dto.role.UpdateDto;
import course.linkflower.link.system.vo.role.RoleDetailVo;
import course.linkflower.link.system.vo.role.RoleVo;
import course.linkflower.link.system.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1 + "/role")
@RefreshScope
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    public Result<RoleVo> add(@RequestBody AddDto addDto) throws BusinessException {
        return Result.succeed(roleService.add(addDto));
    }

    @PostMapping("/getOne")
    public Result<RoleVo> getOne(@RequestBody IdDto idDto) throws BusinessException {
        return Result.succeed(roleService.getOne(idDto));
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody IdDto idDto) {
        roleService.delete(idDto);
        return Result.succeed();
    }

    @PostMapping("/update")
    public Result<RoleVo> update (@RequestBody UpdateDto updateDto) throws BusinessException{
        return Result.succeed(roleService.update(updateDto));
    }

    @PostMapping("/search")
    public PageResult<RoleVo> search(@RequestBody SearchDto searchDto) {
        return roleService.search(searchDto);
    }

    @PostMapping("/detail")
    public Result<RoleDetailVo> detail(@RequestBody IdDto idDto) {
        return Result.succeed(roleService.detail(idDto));
    }
}
