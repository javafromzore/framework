package course.linkflower.link.system.service;

import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.system.dto.role.AddDto;
import course.linkflower.link.system.dto.role.SearchDto;
import course.linkflower.link.system.dto.role.UpdateDto;
import course.linkflower.link.system.vo.role.RoleDetailVo;
import course.linkflower.link.system.vo.role.RoleVo;

public interface RoleService {
   RoleVo add(AddDto addDto);

   RoleVo getOne(IdDto idDto);

    void delete(IdDto idDto);

   RoleVo update(UpdateDto updateDto);

    PageResult<RoleVo> search(SearchDto searchDto);

    RoleDetailVo detail(IdDto idDto);
}
