package course.linkflower.link.oneframework.car.service;

import course.linkflower.link.oneframework.car.vo.modification.ModificationVo;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.dto.modification.AddDto;
import course.linkflower.link.oneframework.car.dto.modification.SearchDto;
import course.linkflower.link.oneframework.car.dto.modification.UpdateDto;

public interface ModificationService {

    Result<ModificationVo> add(AddDto addDto);

    Result<ModificationVo> getById(IdDto idDto);

    PageResult<ModificationVo> search(SearchDto searchDto);

    Result<ModificationVo> update(UpdateDto updateDto);

    Result delete(IdDto idDto);
}
