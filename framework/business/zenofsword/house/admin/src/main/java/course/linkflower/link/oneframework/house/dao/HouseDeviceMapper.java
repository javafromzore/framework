package course.linkflower.link.oneframework.house.dao;

import course.linkflower.link.oneframework.house.model.AreaInfo;
import course.linkflower.link.oneframework.house.model.HouseDevice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

@Mapper
public interface HouseDeviceMapper {
    int save (HouseDevice houseDevice);
    int delete(@Param("id") long id);
    int update(HouseDevice houseDevice);
<<<<<<< .merge_file_l3M0Wf
    HouseDevice getHouseDeviceById(@Param("id") long id);
    int countByHouseDeviceTypeId(@Param("rentHouseInfoId") long rentHouseInfoId,@Param("houseDeviceTypeId") long houseDeviceTypeId);
    int saves(@Param("id") long id ,@Param("array") Long[] ids);
    int deleteHouseDevice(@Param("id") long id);
=======
    HouseDevice getById(@Param("id") long id);
    int countRepeat(@Param("rentHouseInfoId") long rentHouseInfoId,@Param("houseDeviceTypeId") long houseDeviceTypeId);
    int saves(@Param("id") long id ,@Param("array") Long[] ids );
    int deletes(@Param("id") long id);
>>>>>>> .merge_file_xSLsv6
}
