package course.linkflower.link.oneframework.car.service;

import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.dto.usedcar.SearchDto;
import course.linkflower.link.oneframework.car.dto.usedcar.UsedCarDto;
import course.linkflower.link.oneframework.car.dto.usedcar.AddDto;
import course.linkflower.link.oneframework.car.vo.usedcar.UsedCarVo;

public interface UsedCarService {

    Result<UsedCarVo> add(AddDto addDto);

    Result delete(IdDto idDto);

    Result<UsedCarVo> update(UsedCarDto usedCarDto);

    Result<UsedCarVo> getById(IdDto idDto);

    PageResult<UsedCarVo> search(SearchDto searchDto);
}
