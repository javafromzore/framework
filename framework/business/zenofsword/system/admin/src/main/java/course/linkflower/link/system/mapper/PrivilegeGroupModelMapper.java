package course.linkflower.link.system.mapper;

import course.linkflower.link.system.dto.privilegegroup.AddDto;
import course.linkflower.link.system.dto.privilegegroup.UpdateDto;
import course.linkflower.link.system.model.PrivilegeGroup;
import course.linkflower.link.system.vo.privilegegroup.PrivilegeGroupVo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrivilegeGroupModelMapper {
    List<Long> IdsConvertLong(String[] ids);

    PrivilegeGroup updateToPrivilegeGroup(UpdateDto updateDto);

    PrivilegeGroup addToPrivilegeGroup(AddDto addDto);

    PrivilegeGroupVo priviGroupToVo(PrivilegeGroup priviGroup);
}
