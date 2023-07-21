package course.linkflower.link.system.dao;

import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.system.vo.user.UserInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.util.List;
@Mapper
public interface UserRoleMapper extends SuperMapper<UserRoleMapper> {
    List<UserInfoVo> UserInfo(@Param("roleId") long roleId);

    List<Long> roleIds(@Param("userId") long userId);
}
