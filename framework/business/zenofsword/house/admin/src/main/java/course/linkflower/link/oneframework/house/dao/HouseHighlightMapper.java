package course.linkflower.link.oneframework.house.dao;

import course.linkflower.link.oneframework.house.model.HouseHighlight;
import course.linkflower.link.oneframework.house.model.HouseHightlightInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

@Mapper
public interface HouseHighlightMapper {
    int save (HouseHighlight houseHighlight);
    int delete(@Param("id") long id);
    int update(HouseHighlight houseHighlight);
    HouseHighlight getById(@Param("id") long id);
    int countRepeat(@Param("rentHouseInfoId") long rentHouseInfoId,@Param("HighlightId") long HighlightId);

    int saves(@Param("id") long id ,@Param("array") Long[] ids );
    int deletes(@Param("id") long id);
}
