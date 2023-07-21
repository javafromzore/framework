package course.linkflower.link.oneframework.house.service;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.housedevicetype.HousePageDto;
import course.linkflower.link.oneframework.house.dto.renthouserequestinfo.AddDto;
import course.linkflower.link.oneframework.house.dto.renthouserequestinfo.DeleteDto;
import course.linkflower.link.oneframework.house.dto.renthouserequestinfo.UpdateDto;
import course.linkflower.link.oneframework.house.model.HousePageResult;
import course.linkflower.link.oneframework.house.vo.renthouserequestinfo.RentHouseRequestInfoVo;

public interface RentHouseRequestInfoService {
    Result<RentHouseRequestInfoVo> add(AddDto addDto);
    Result delete(DeleteDto deleteDto);
    Result<RentHouseRequestInfoVo> update(UpdateDto updateDto);
    HousePageResult<RentHouseRequestInfoVo> search(HousePageDto housePageDto);
}
