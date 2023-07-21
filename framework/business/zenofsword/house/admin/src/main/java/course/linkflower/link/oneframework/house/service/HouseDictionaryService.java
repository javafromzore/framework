package course.linkflower.link.oneframework.house.service;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.base.IdDto;
import course.linkflower.link.oneframework.house.dto.housedevicetype.HousePageDto;
import course.linkflower.link.oneframework.house.dto.housedictionary.*;
import course.linkflower.link.oneframework.house.model.HousePageResult;
import course.linkflower.link.oneframework.house.vo.housedictionary.HouseDictionaryVo;
import course.linkflower.link.oneframework.house.vo.housedictionary.ShortHouseDictionaryVo;

import java.util.List;

public interface HouseDictionaryService {

    Result<List<ShortHouseDictionaryVo>> listType(ChooseDto chooseDto);

    Result<HouseDictionaryVo> add(AddDto addDto);
    Result delete(DeleteDto deleteDto);
    Result<HouseDictionaryVo> update(UpdateDto updateDto);
    HousePageResult<HouseDictionaryVo> search(HousePageDto housePageDto);

    Result<HouseDictionaryVo> getById(IdDto idDto);
}
