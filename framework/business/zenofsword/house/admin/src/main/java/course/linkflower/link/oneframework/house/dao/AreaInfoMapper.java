package course.linkflower.link.oneframework.house.dao;

import course.linkflower.link.oneframework.house.model.AreaInfo;
import course.linkflower.link.oneframework.house.model.CommunityInfo;
import course.linkflower.link.oneframework.house.vo.areainfo.AreaTypeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

@Mapper
public interface AreaInfoMapper {
    int save (AreaInfo areaInfo);
    int delete(@Param("id") long id);
    int update(AreaInfo areaInfo);
    AreaInfo getById(@Param("id") long id);
    List<AreaInfo> listByName(@Param("name") String name);
    List<AreaInfo> listByIds(@Param("ids") Long[] ids);
    List<AreaInfo> listByHouseId(@Param("id") long id,@Param("type") String type);
}
