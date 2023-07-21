package course.linkflower.link.oneframework.house.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

@Mapper
public interface RentHouseRequestMapper {
    int saves(@Param("id") long id , @Param("array") Long[] ids );
    int deletes(@Param("id") long id);
}
