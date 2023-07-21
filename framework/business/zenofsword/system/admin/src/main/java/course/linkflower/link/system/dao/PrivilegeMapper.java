package course.linkflower.link.system.dao;

import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.system.dto.privilege.SearchDto;
import course.linkflower.link.system.model.Privilege;
import course.linkflower.link.system.vo.privilege.PrivilegeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PrivilegeMapper extends SuperMapper<PrivilegeMapper> {
    int countCode(@Param("code") String code);

    int add(Privilege privi);

    Integer countLast(@Param("type") String type);

    int deleteAllByIds(@Param("ids") List<Long> ids);

    int deleteAllById(@Param("id") long id);

    int update(Privilege privi);

    Privilege getOne(@Param("id") long id);

    List<PrivilegeVo> search(SearchDto searchDto);

    int countTotal(SearchDto searchDto);
}
