package course.linkflower.link.oneframework.house.service;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.housedevicetype.HousePageDto;
import course.linkflower.link.oneframework.house.dto.househighlightinfo.AddDto;
import course.linkflower.link.oneframework.house.dto.househighlightinfo.DeleteDto;
import course.linkflower.link.oneframework.house.dto.househighlightinfo.UpdateDto;
import course.linkflower.link.oneframework.house.model.HousePageResult;
import course.linkflower.link.oneframework.house.vo.househightlightinfo.HouseHightlightInfoVo;

public interface HouseHightlightInfoService {
    Result<HouseHightlightInfoVo> add(AddDto addDto);
    Result delete(DeleteDto deleteDto);
    Result<HouseHightlightInfoVo> update(UpdateDto updateDto);
    HousePageResult<HouseHightlightInfoVo> search(HousePageDto housePageDto);
}
