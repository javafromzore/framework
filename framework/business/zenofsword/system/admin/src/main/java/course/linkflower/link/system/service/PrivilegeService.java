package course.linkflower.link.system.service;

import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.system.dto.privilege.AddDto;
import course.linkflower.link.system.dto.privilege.SearchDto;
import course.linkflower.link.system.dto.privilege.UpdateDto;
import course.linkflower.link.system.vo.privilege.PrivilegeVo;

public interface PrivilegeService {
    PrivilegeVo add(AddDto addDto);

    PrivilegeVo getOne(IdDto idDto);

    void delete(IdDto idDto);

    PrivilegeVo update(UpdateDto updateDto);

    PageResult<PrivilegeVo> search(SearchDto searchDto);
}
