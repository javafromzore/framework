package course.linkflower.link.system.dao;

import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PrivilegePrivilegeGroupMapper extends SuperMapper<PrivilegePrivilegeGroupMapper> {
    int saves(@Param("priviGroupId") Long priviGroupId, @Param("priviIds") List<Long> priviIds);
}
