package course.linkflower.link.oneframework.house.dao;

import course.linkflower.link.oneframework.house.dto.housedevicetype.HousePageDto;
import course.linkflower.link.oneframework.house.model.HouseDeviceType;
import course.linkflower.link.oneframework.house.model.HouseHightlightInfo;
import course.linkflower.link.oneframework.house.vo.housedictionary.HouseDictionaryVo;
import course.linkflower.link.oneframework.house.vo.househightlightinfo.HouseHightlightInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HouseHightlightInfoMapper {
    int save (HouseHightlightInfo houseHightlightInfo);
    int delete(@Param("id") long id);
    int deleteAll(@Param("ids") long[] ids);
    int update(HouseHightlightInfo houseHightlightInfo);
    HouseHightlightInfo getById(@Param("id") long id);
    int countByName(@Param("name") String name);
    List<HouseHightlightInfoVo> search(HousePageDto housePageDto);
    long countAll();
    List<HouseHightlightInfo> listByHouseId(@Param("id") long id);
}
