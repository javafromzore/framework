package course.linkflower.link.system.service;

import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.system.dto.role.SearchDto;
import course.linkflower.link.system.dto.usergroup.AddDto;
import course.linkflower.link.system.dto.usergroup.UpdateDto;
import course.linkflower.link.system.vo.usergroup.UserGroupVo;

public interface UserGroupService {
    UserGroupVo add(AddDto addDto);

    UserGroupVo getOne(IdDto idDto);

    void delete(IdDto idDto);

    UserGroupVo update(UpdateDto updateDto);

    PageResult<UserGroupVo> search(SearchDto searchDto);
}
