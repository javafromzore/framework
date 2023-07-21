package course.linkflower.link.oneframework.car.service;

import course.linkflower.link.oneframework.car.dto.cardict.AddDto;
import course.linkflower.link.oneframework.car.dto.cardict.SearchDto;
import course.linkflower.link.oneframework.car.dto.cardict.UpdateDto;
import course.linkflower.link.oneframework.car.vo.cardict.CarDictInfoVo;
import course.linkflower.link.oneframework.car.vo.cardict.CarDictVo;
import course.linkflower.link.oneframework.car.vo.cardict.SearchVo;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.dto.base.TypeDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;

import java.util.List;

public interface CarDictService {
    Result<CarDictVo> add(AddDto addDto);

    Result delete(IdDto idDto);

    Result<CarDictVo> update(UpdateDto updateDto);

    PageResult<SearchVo> search(SearchDto searchDto);

    Result<List<CarDictInfoVo>> listInfosByType(TypeDto typeDto);

    Result<CarDictVo> getById(IdDto idDto);
}
