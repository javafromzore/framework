package course.linkflower.link.system.dao;

import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.system.dto.role.SearchDto;
import course.linkflower.link.system.model.UserGroup;
import course.linkflower.link.system.vo.usergroup.UserGroupVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserGroupMapper extends SuperMapper<UserGroupMapper> {
    int countCode(@Param("code") String code);

    Integer countLast(@Param("type")String type);

    int add(UserGroup userGroup);

    UserGroup getOne(@Param("id")long id);

    int deleteAllByIds(@Param("ids")List<Long> ids);

    int deleteAllById(@Param("id")long id);

    int update(UserGroup userGroup);

    List<UserGroupVo> search(SearchDto searchDto);

    int countTotal(SearchDto searchDto);
}
