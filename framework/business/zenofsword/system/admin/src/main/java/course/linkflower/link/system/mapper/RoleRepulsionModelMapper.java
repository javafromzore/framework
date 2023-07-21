package course.linkflower.link.system.mapper;

import course.linkflower.link.system.dto.rolerepulsion.AddDto;
import course.linkflower.link.system.dto.rolerepulsion.RoleIdDto;
import course.linkflower.link.system.dto.rolerepulsion.UpdateDto;
import course.linkflower.link.system.model.RoleRepulsion;
import course.linkflower.link.system.vo.rolerepulsion.RoleRepulsionVo;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleRepulsionModelMapper {
    RoleRepulsion addToRoleRepul(AddDto addDto);

    RoleRepulsionVo roleRepulToVo(RoleRepulsion roleRepul);
//    @Mapping(target = "roleIdDto", qualifiedByName = "toRoleIdDto")
//    List<RoleIdDto> toRoleIdDtos(@Context List<Long> roleIdA, @Context List<Long> roleIdB);
//    @Named("toRoleIdDto")
//    default RoleIdDto toRoleIdDto(List<Long> roleIdA, List<Long> roleIdB){
//
//    }

    RoleRepulsion updateToRoleRepul(UpdateDto updateDto);

    List<Long> idsToLong(String[] ids);
}
