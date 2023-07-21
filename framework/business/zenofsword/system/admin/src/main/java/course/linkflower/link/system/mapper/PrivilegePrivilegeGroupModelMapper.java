package course.linkflower.link.system.mapper;

import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.system.vo.privilege.CodeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PrivilegePrivilegeGroupModelMapper extends SuperMapper<PrivilegePrivilegeGroupModelMapper> {
    List<CodeVo> priviCodesByIds(@Param("priviGroupIds") List<Long> priviGroupIds);
}
