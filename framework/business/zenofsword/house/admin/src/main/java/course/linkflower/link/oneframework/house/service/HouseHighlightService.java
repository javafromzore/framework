package course.linkflower.link.oneframework.house.service;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.househightlight.AddDto;
import course.linkflower.link.oneframework.house.dto.househightlight.DeleteDto;
import course.linkflower.link.oneframework.house.dto.househightlight.SearchDto;
import course.linkflower.link.oneframework.house.dto.househightlight.UpdateDto;
import course.linkflower.link.oneframework.house.vo.househighlight.HouseHighlightVo;

public interface HouseHighlightService {
    Result<HouseHighlightVo> add(AddDto addDto);
    Result delete(DeleteDto deleteDto);
    Result<HouseHighlightVo> update(UpdateDto updateDto);
    Result<HouseHighlightVo> getById(SearchDto searchDto);
}
