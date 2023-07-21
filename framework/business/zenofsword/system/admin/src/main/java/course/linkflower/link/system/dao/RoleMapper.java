package course.linkflower.link.system.dao;

import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.system.dto.role.SearchDto;
import course.linkflower.link.system.model.Role;
import course.linkflower.link.system.vo.role.RoleInfoVo;
import course.linkflower.link.system.vo.role.RoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface RoleMapper extends SuperMapper<RoleMapper> {
    int countCode(@Param("code") String code);

    Integer countLast(@Param("type") String type);

    List<RoleVo> search(SearchDto searchDto);

    int countTotal(SearchDto searchDto);

    int add(Role role);

    Role getOne(@Param("id") long id);

    int deleteByIds(@Param("ids") List<Long> ids);

    int deleteById(@Param("id") long id);

    int update(Role role);

    List<RoleInfoVo> listInfo(@Param("ids") List<Long> ids);

    int countCodeDiffId(@Param("code") String code, @Param("id") long id);
}
