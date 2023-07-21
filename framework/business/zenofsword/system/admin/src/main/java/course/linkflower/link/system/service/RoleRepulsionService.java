package course.linkflower.link.system.service;

import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.system.dto.rolerepulsion.AddDto;
import course.linkflower.link.system.dto.rolerepulsion.DeleteDto;
import course.linkflower.link.system.dto.rolerepulsion.UpdateDto;
import course.linkflower.link.system.vo.rolerepulsion.RoleRepulsionVo;

public interface RoleRepulsionService {
    RoleRepulsionVo add(AddDto addDto);

    void delete(DeleteDto deleteDto);

    RoleRepulsionVo update(UpdateDto updateDto);

    RoleRepulsionVo getOne(IdDto idDto);
}
