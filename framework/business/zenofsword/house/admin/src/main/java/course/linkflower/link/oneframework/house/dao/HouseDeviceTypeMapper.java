package course.linkflower.link.oneframework.house.dao;

import course.linkflower.link.oneframework.house.dto.housedevicetype.HousePageDto;
import course.linkflower.link.oneframework.house.model.AreaInfo;
import course.linkflower.link.oneframework.house.model.HouseDeviceType;
import course.linkflower.link.oneframework.house.vo.housedevicetype.HouseDeviceTypeInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HouseDeviceTypeMapper {
    int save (HouseDeviceType houseDeviceType);
    int delete(@Param("id") long id);
    int deleteAll(@Param("ids") Long[] ids);
    int update(HouseDeviceType houseDeviceType);
    int countByName(@Param("name") String name);
    HouseDeviceType getById(@Param("id") long id);
    List<HouseDeviceTypeInfoVo> search(HousePageDto housePageDto);
    long countAll();
    List<HouseDeviceTypeInfoVo> listByType(@Param("type") String type);
    List<HouseDeviceType> listByHouseId(@Param("id") long id);
}
