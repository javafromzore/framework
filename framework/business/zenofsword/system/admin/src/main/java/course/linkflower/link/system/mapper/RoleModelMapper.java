package course.linkflower.link.system.mapper;

import course.linkflower.link.system.dto.role.AddDto;
import course.linkflower.link.system.dto.role.PriviIdDto;
import course.linkflower.link.system.dto.role.UpdateDto;
import course.linkflower.link.system.model.Role;
import course.linkflower.link.system.vo.privilege.PrivilegeInfoVo;
import course.linkflower.link.system.vo.privilegegroup.PrivilegeGroupInfoVo;
import course.linkflower.link.system.vo.role.RoleDetailVo;
import course.linkflower.link.system.vo.role.RoleInfoVo;
import course.linkflower.link.system.vo.role.RoleVo;
import course.linkflower.link.system.vo.user.UserInfoVo;
import course.linkflower.link.system.vo.usergroup.UserGroupInfoVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;
@Mapper(componentModel = "spring")
public interface RoleModelMapper {
    Role addToRole(AddDto addDto);

    RoleVo roleToVo(Role role);

    List<Long> IdsConvertLong(String[] ids);

    Role updateToRole(UpdateDto updateDto);

    RoleVo updateToVo(UpdateDto updateDto);
    @Mappings({
            @Mapping(target = "userInfoVos", source = "userInfo"),
            @Mapping(target = "userGroupInfoVos", source = "userGroupInfo"),
            @Mapping(target = "priviGroupInfoVos", source = "priviGroupInfo"),
            @Mapping(target = "priviInfoVos", source = "priviInfo"),
            @Mapping(target = "roleInfoVos", source = "roleInfoVos")
    })
    RoleDetailVo toDetail(List<UserInfoVo> userInfo,
                          List<UserGroupInfoVo> userGroupInfo,
                          List<PrivilegeGroupInfoVo> priviGroupInfo,
                          List<PrivilegeInfoVo> priviInfo,
                          List<RoleInfoVo> roleInfoVos);

    List<Long> IdsToLong(String[] roleIds);

//    List<PriviIdDto> toPriviIds(List<String> beforPriviIds, List<String> afterPriviIds);
}
