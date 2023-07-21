package course.linkflower.link.oneframework.car.service;

import course.linkflower.link.oneframework.car.vo.annualmodel.AnnualModelVo;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.dto.annualmodel.AddDto;
import course.linkflower.link.oneframework.car.dto.annualmodel.SearchDto;
import course.linkflower.link.oneframework.car.dto.annualmodel.UpdateDto;

public interface AnnualModelServiceI {
    Result<AnnualModelVo> add(AddDto addDto);

    Result delete(IdDto idDto);

    Result<AnnualModelVo> update(UpdateDto updateDto);

    PageResult<AnnualModelVo> search(SearchDto searchDto);

    Result<AnnualModelVo> getById(IdDto idDto);
}
