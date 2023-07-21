package course.linkflower.link.oneframework.house.service;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.base.IdDto;
import course.linkflower.link.oneframework.house.dto.housedevicetype.HousePageDto;
import course.linkflower.link.oneframework.house.dto.renthouseinfo.*;
import course.linkflower.link.oneframework.house.model.HousePageResult;
import course.linkflower.link.oneframework.house.vo.renthouseinfo.HouseDetailsInfoVo;
import course.linkflower.link.oneframework.house.vo.renthouseinfo.RentHouseInfoVo;
import course.linkflower.link.oneframework.house.vo.renthouseinfo.ShortHouseInfoVo;

public interface RentHouseInfoService {
    Result<RentHouseInfoVo> add(AddDto addDto);
    Result delete(DeleteDto deleteDto);
    Result<RentHouseInfoVo> update(AddDto addDto);
    Result<HouseDetailsInfoVo> details(IdDto idDto);
    Result<RentHouseInfoVo> getById(IdDto idDto);
    HousePageResult<ShortHouseInfoVo> search(HousePageDto housePageDto);
}
