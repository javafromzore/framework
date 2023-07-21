package course.linkflower.link.oneframework.house.dao;

import course.linkflower.link.oneframework.house.model.AreaInfo;
import course.linkflower.link.oneframework.house.model.AreaProductDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

@Mapper
public interface AreaProductDetailsMapper {
    int save (AreaProductDetails areaProductDetails);
    int delete(@Param("id") long id);
    int update(AreaProductDetails areaProductDetails);

    int updates(@Param("list") List<AreaProductDetails> areaProductDetails);
    AreaProductDetails getById(@Param("id") long id);
    int countByAreaTargetType(AreaProductDetails areaProductDetails);
    List<AreaProductDetails> listByIds(@Param("ids") Long[] ids);
    int saves(@Param("id") long id ,@Param("array") Long[] ids );
    int deletes(@Param("id") long id);
}
