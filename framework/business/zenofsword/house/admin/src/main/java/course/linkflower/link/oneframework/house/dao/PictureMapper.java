package course.linkflower.link.oneframework.house.dao;

import course.linkflower.link.oneframework.house.model.Commission;
import course.linkflower.link.oneframework.house.model.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PictureMapper {
    int save (Picture picture);
    int delete(@Param("id") long id);
    int update(Picture picture);
    Picture getById(@Param("id") long id);
}
