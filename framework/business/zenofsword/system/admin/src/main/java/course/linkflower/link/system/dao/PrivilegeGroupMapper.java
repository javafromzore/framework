package course.linkflower.link.system.dao;

import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.system.dto.privilegegroup.SearchDto;
import course.linkflower.link.system.model.PrivilegeGroup;
import course.linkflower.link.system.vo.privilegegroup.PrivilegeGroupVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PrivilegeGroupMapper extends SuperMapper<PrivilegeGroupMapper> {
    int countCode(@Param("code") String code);

    Integer countLast(@Param("type")String type);

    int add(PrivilegeGroup privilegeGroup);

    PrivilegeGroup getOne(@Param("id")long id);

    int deleteAllByIds(@Param("ids") List<Long> ids);

    int deleteAllById(@Param("id")long id);

    int update(PrivilegeGroup privilegeGroup);

    List<PrivilegeGroupVo> search(SearchDto searchDto);

    int countTotal(SearchDto searchDto);
}
