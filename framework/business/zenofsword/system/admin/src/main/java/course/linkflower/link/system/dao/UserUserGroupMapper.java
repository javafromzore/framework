package course.linkflower.link.system.dao;

import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserUserGroupMapper extends SuperMapper<UserUserGroupMapper> {
    List<Long> userGroupIds(@Param("userId") long userId);
}
