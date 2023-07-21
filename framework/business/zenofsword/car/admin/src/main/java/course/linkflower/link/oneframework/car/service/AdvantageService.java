package course.linkflower.link.oneframework.car.service;

import course.linkflower.link.oneframework.car.vo.advantage.AdvantageVo;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.dto.advantage.AddDto;
import course.linkflower.link.oneframework.car.dto.advantage.SearchDto;
import course.linkflower.link.oneframework.car.dto.advantage.UpdateDto;

public interface AdvantageService {

    Result<AdvantageVo> add(AddDto addDto);

    Result<AdvantageVo> getById(IdDto idDto);
    
    Result delete(IdDto idDto);

    Result<AdvantageVo> update(UpdateDto updateDto);

    PageResult<AdvantageVo> search(SearchDto searchDto);
}
