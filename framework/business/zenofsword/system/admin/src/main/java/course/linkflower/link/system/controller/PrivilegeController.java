package course.linkflower.link.system.controller;

import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.exception.BusinessException;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.system.dto.privilege.AddDto;
import course.linkflower.link.system.dto.privilege.SearchDto;
import course.linkflower.link.system.dto.privilege.UpdateDto;
import course.linkflower.link.system.service.PrivilegeService;
import course.linkflower.link.system.vo.privilege.PrivilegeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1 + "/privilege")
@RefreshScope
public class PrivilegeController {
    @Autowired
    private PrivilegeService priviService;

    @PostMapping("/add")
    public Result<PrivilegeVo> add(@RequestBody AddDto addDto) throws BusinessException {
        return Result.succeed(priviService.add(addDto));
    }

    @PostMapping("/getOne")
    public Result<PrivilegeVo> getOne(@RequestBody IdDto idDto) throws BusinessException {
        return Result.succeed(priviService.getOne(idDto));
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody IdDto idDto) {
        priviService.delete(idDto);
        return Result.succeed();
    }

    @PostMapping("/update")
    public Result<PrivilegeVo> update (@RequestBody UpdateDto updateDto) throws BusinessException{
        return Result.succeed(priviService.update(updateDto));
    }

    @PostMapping("/search")
    public PageResult<PrivilegeVo> search(@RequestBody SearchDto searchDto) {
        return priviService.search(searchDto);
    }
}
