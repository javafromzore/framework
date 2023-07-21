package course.linkflower.link.oneframework.dao;

import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends SuperMapper<UserMapper> {
    int countPhone(@Param("phone") String phone);

    int countName(@Param("name") String name);
}
