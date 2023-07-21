package course.linkflower.link.oneframework.house.dao;

import course.linkflower.link.oneframework.house.dto.housedevicetype.HousePageDto;
import course.linkflower.link.oneframework.house.model.HouseHightlightInfo;
import course.linkflower.link.oneframework.house.model.RentHouseRequestInfo;
import course.linkflower.link.oneframework.house.vo.househightlightinfo.HouseHightlightInfoVo;
import course.linkflower.link.oneframework.house.vo.renthouserequestinfo.RentHouseRequestInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RentHouseRequestInfoMapper {
    int save (RentHouseRequestInfo rentHouseRequestInfo);
    int delete(@Param("id") long id);
    int deleteAll(@Param("ids") Long[] ids);
    int update(RentHouseRequestInfo rentHouseRequestInfo);
    RentHouseRequestInfo getById(@Param("id") long id);
    int countByName(@Param("name") String name);
    List<RentHouseRequestInfoVo> search(HousePageDto housePageDto);
    List<RentHouseRequestInfoVo> listAll(HousePageDto housePageDto);
    long countAll();
    List<RentHouseRequestInfo> listByHouseId(@Param("id") long id);
}
