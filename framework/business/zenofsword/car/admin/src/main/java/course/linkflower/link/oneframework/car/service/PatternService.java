package course.linkflower.link.oneframework.car.service;

import course.linkflower.link.oneframework.car.vo.pattern.PatternDetailVo;
import course.linkflower.link.oneframework.car.vo.pattern.PatternVo;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.car.dto.pattern.SearchDto;
import course.linkflower.link.oneframework.car.dto.pattern.UpdateDto;
import course.linkflower.link.oneframework.car.dto.pattern.AddDto;

public interface PatternService {

   PatternVo add(AddDto addDto);

    void delete(IdDto idDto);

   PatternVo update(UpdateDto updateDto);

   PatternVo getById(IdDto idDto);

    PageResult<PatternVo> search(SearchDto searchDto);

    PatternDetailVo detail(IdDto idDto);
}
