package course.linkflower.link.oneframework.house.dao;

import course.linkflower.link.oneframework.house.model.Menu;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {
    int save(Menu menu);
    int update(Menu menu);
    int delete(@Param("id") long id);
    Menu getById(@Param("id") long id);
    int countByCode(@Param("code") String code);

}
