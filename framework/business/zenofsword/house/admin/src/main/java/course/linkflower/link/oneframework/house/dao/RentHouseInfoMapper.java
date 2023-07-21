package course.linkflower.link.oneframework.house.dao;

import course.linkflower.link.oneframework.house.dto.housedevicetype.HousePageDto;
import course.linkflower.link.oneframework.house.model.HouseDictionary;
import course.linkflower.link.oneframework.house.model.RentHouseInfo;
import course.linkflower.link.oneframework.house.vo.renthouseinfo.ShortHouseInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

@Mapper
public interface RentHouseInfoMapper {
    int save (RentHouseInfo rentHouseInfo);
    int delete(@Param("id") long id);
    int deleteAll(@Param("ids") Long[] id);
    int update(RentHouseInfo rentHouseInfo);
    RentHouseInfo getById(@Param("id") long id);
    List<ShortHouseInfoVo> search(HousePageDto housePageDto);
    long countAll();
}
