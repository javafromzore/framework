package course.linkflower.link.oneframework.house.service;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.renthouseinfo.SearchDto;
import course.linkflower.link.oneframework.house.vo.renthouseinfo.HouseDetailsInfoVo;

public interface RentHouseWholeInfoService {
    Result<HouseDetailsInfoVo> loadInfo(SearchDto searchDto);
}
