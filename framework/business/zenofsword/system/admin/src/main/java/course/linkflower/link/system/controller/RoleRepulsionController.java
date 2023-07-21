package course.linkflower.link.system.controller;

import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.exception.BusinessException;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.system.dto.role.SearchDto;
import course.linkflower.link.system.dto.rolerepulsion.AddDto;
import course.linkflower.link.system.dto.rolerepulsion.DeleteDto;
import course.linkflower.link.system.dto.rolerepulsion.UpdateDto;
import course.linkflower.link.system.service.RoleRepulsionService;
import course.linkflower.link.system.vo.role.RoleVo;
import course.linkflower.link.system.vo.rolerepulsion.RoleRepulsionVo;
import io.micrometer.core.instrument.Meter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1 + "/rolerepulsion")
@RefreshScope
public class RoleRepulsionController {
    @Autowired
    private RoleRepulsionService roleRepulService;
    @PostMapping("/add")
    public Result<RoleRepulsionVo> add(@RequestBody AddDto addDto) throws BusinessException {
        return Result.succeed(roleRepulService.add(addDto));
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteDto deleteDto){
        roleRepulService.delete(deleteDto);
        return Result.succeed();
    }

    @PostMapping("/update")
    public Result<RoleRepulsionVo> update(@RequestBody UpdateDto updateDto) throws BusinessException {
        return Result.succeed(roleRepulService.update(updateDto));
    }

    @PostMapping("/getOne")
    public Result<RoleRepulsionVo> getOne(@RequestBody IdDto idDto) throws BusinessException {
        return Result.succeed(roleRepulService.getOne(idDto));
    }
}
