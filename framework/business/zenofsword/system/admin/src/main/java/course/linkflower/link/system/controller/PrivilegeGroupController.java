package course.linkflower.link.system.controller;

import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.exception.BusinessException;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.system.dto.privilegegroup.AddDto;
import course.linkflower.link.system.dto.privilegegroup.SearchDto;
import course.linkflower.link.system.dto.privilegegroup.UpdateDto;
import course.linkflower.link.system.service.PrivilegeGroupService;
import course.linkflower.link.system.vo.privilegegroup.PrivilegeGroupVo;
import course.linkflower.link.system.vo.role.RoleDetailVo;
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
@RequestMapping(ApisConstant.ApiV1 + "/privilegegroup")
@RefreshScope
public class PrivilegeGroupController {
    @Autowired
    private PrivilegeGroupService pgService;

    @PostMapping("/add")
    public Result<PrivilegeGroupVo> add(@RequestBody AddDto addDto) throws BusinessException {
        return Result.succeed(pgService.add(addDto));
    }

    @PostMapping("/getOne")
    public Result<PrivilegeGroupVo> getOne(@RequestBody IdDto idDto) throws BusinessException {
        return Result.succeed(pgService.getOne(idDto));
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody IdDto idDto) {
        pgService.delete(idDto);
        return Result.succeed();
    }

    @PostMapping("/update")
    public Result<PrivilegeGroupVo> update (@RequestBody UpdateDto updateDto) throws BusinessException{
        return Result.succeed(pgService.update(updateDto));
    }

    @PostMapping("/search")
    public PageResult<PrivilegeGroupVo> search(@RequestBody SearchDto searchDto) {
        return pgService.search(searchDto);
    }
}
