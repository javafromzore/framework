package course.linkflower.link.oneframework.car.service;

import course.linkflower.link.oneframework.car.dto.dict.AddDto;
import course.linkflower.link.oneframework.car.dto.dict.SearchDto;
import course.linkflower.link.oneframework.car.dto.dict.UpdateDto;
import course.linkflower.link.oneframework.car.vo.dict.DictVo;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.dto.base.TypeDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;

import java.util.List;

public interface DictService {
    Result<DictVo> add(AddDto addDto);

    Result delete(IdDto idDto);

    Result<DictVo> update(UpdateDto updateDto);

    Result<List<DictVo>> listByType(TypeDto typeDto);

    PageResult<DictVo> search(SearchDto searchDto);

    Result<DictVo> getById(IdDto idDto);
}
