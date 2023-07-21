package course.linkflower.link.system.mapper;

import course.linkflower.link.system.dto.usergroup.AddDto;
import course.linkflower.link.system.dto.usergroup.UpdateDto;
import course.linkflower.link.system.model.UserGroup;
import course.linkflower.link.system.vo.usergroup.UserGroupVo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserGroupModelMapper {
    UserGroup addToUserGroup(AddDto addDto);

    UserGroupVo userGroupToVo(UserGroup userGroup);

    List<Long> IdsConvertLong(String[] ids);

    UserGroup updateToUserGroup(UpdateDto updateDto);
}
