package course.linkflower.link.system.dao;

import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.system.dto.role.PriviIdDto;
import course.linkflower.link.system.vo.privilege.CodeVo;
import course.linkflower.link.system.vo.privilege.PrivilegeInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RolePrivilegeMapper extends SuperMapper<RolePrivilegeMapper> {

    int savas(@Param("priviIds") List<Long> priviIds,@Param("roleId") long roleId);

    int updates(@Param("roleId") long roleId,@Param("priviIdDtos") List<PriviIdDto> priviIdDtos);

    List<PrivilegeInfoVo> priviInfo(@Param("roleId") long roleId);

    List<CodeVo> priviCodesByIds(@Param("roleIds") List<Long> roleIds);
}
