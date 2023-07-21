package course.linkflower.link.oneframework.house.service;

import course.linkflower.link.oneframework.common.dto.base.TypeDto;
import course.linkflower.link.oneframework.house.model.HousePageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.housedevicetype.*;
import course.linkflower.link.oneframework.house.vo.housedevicetype.HouseDeviceTypeInfoVo;
import course.linkflower.link.oneframework.house.vo.housedevicetype.HouseDeviceTypeVo;

import java.util.List;

public interface HouseDeviceTypeService {
    Result<HouseDeviceTypeVo> add(AddDto addDto);
    Result delete(DeleteDto deleteDto);
    Result<HouseDeviceTypeVo> update(UpdateDto updateDto);
    Result<HouseDeviceTypeVo> getOne(SearchDto searchDto);
    HousePageResult<HouseDeviceTypeInfoVo> search(HousePageDto housePageDto);

    Result<List<HouseDeviceTypeInfoVo>> listByType(TypeDto typeDto);
}
