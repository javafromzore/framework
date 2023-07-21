package course.linkflower.link.system.dao;


import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.system.vo.usergroup.UserGroupInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface RoleUserGroupMapper extends SuperMapper<RoleUserGroupMapper> {
    List<UserGroupInfoVo> userGroupInfo(@Param("roleId") long roleId);

    List<Long> roleIdsByIds(@Param("userGroupIds") List<Long> userGroupIds);

    int saves(@Param("userGroupId") Long userGroupId,@Param("roleIds") List<Long> roleIds);
}
