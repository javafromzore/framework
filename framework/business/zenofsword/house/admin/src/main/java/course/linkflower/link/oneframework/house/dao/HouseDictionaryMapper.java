package course.linkflower.link.oneframework.house.dao;

import course.linkflower.link.oneframework.house.dto.housedevicetype.HousePageDto;
import course.linkflower.link.oneframework.house.model.HouseDictionary;
import course.linkflower.link.oneframework.house.vo.housedictionary.HouseDictionaryTypeVo;
import course.linkflower.link.oneframework.house.vo.housedictionary.HouseDictionaryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

@Mapper
public interface HouseDictionaryMapper {
    int save (HouseDictionary houseDictionary);
    int delete(@Param("id") long id);
    int deleteAll(@Param("ids") Long[] ids);
    int update(HouseDictionary houseDictionary);
    HouseDictionary getById(@Param("id") long id);
    int lastSortValueByType(@Param("type") String key);
    int countByTypeKey(@Param("type") String type,@Param("key") String key);
    List<HouseDictionaryVo> search(HousePageDto housePageDto);
    long countAll();
    List<HouseDictionary> listByType(@Param("type") String type);
    long getId();
    List<HouseDictionary> ListByIds(@Param("ids") Collection<Long> ids);

}
