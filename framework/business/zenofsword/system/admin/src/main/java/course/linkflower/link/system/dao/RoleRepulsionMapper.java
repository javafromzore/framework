package course.linkflower.link.system.dao;

import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.system.dto.rolerepulsion.RoleIdDto;
import course.linkflower.link.system.model.RoleRepulsion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface RoleRepulsionMapper extends SuperMapper<RoleRepulsionMapper> {
    List<Long> listAnotherId(@Param("roleId") long roleId);

    int countRoleId(@Param("roleIdA") long roleIdA, @Param("roleIdB") long roleIdB);

    Integer add(RoleRepulsion roleRepul);

    int update(RoleRepulsion roleRepul);

    RoleRepulsion getOne(@Param("id") long id);

    int deleteByRoleIds(@Param("roleIdDtos") List<RoleIdDto> roleIdDtos);

    int deleteByOneRoleId(@Param("roleId") long roleId);

    int deleteByOneRoleIds(@Param("roleIds") List<Long> roleIds);
}
