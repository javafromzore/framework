package course.linkflower.link.system.dao;

import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.system.vo.privilegegroup.PrivilegeGroupInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface RolePrivilegeGroupMapper extends SuperMapper<RolePrivilegeGroupMapper> {
    List<PrivilegeGroupInfoVo> priviGroupInfo(@Param("roleId") long roleId);

    List<Long> priviGroupIdsByIds(@Param("roleIds") List<Long> roleIds);
}
