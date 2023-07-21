package course.linkflower.link.system.service;

import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.system.dto.privilegegroup.AddDto;
import course.linkflower.link.system.dto.privilegegroup.SearchDto;
import course.linkflower.link.system.dto.privilegegroup.UpdateDto;
import course.linkflower.link.system.vo.privilegegroup.PrivilegeGroupVo;

public interface PrivilegeGroupService {
    PrivilegeGroupVo add(AddDto addDto);

    PrivilegeGroupVo getOne(IdDto idDto);

    void delete(IdDto idDto);

    PrivilegeGroupVo update(UpdateDto updateDto);

    PageResult<PrivilegeGroupVo> search(SearchDto searchDto);
}
