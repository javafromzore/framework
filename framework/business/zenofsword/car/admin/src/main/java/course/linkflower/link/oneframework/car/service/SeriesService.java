package course.linkflower.link.oneframework.car.service;

import course.linkflower.link.oneframework.car.dto.series.AddDto;
import course.linkflower.link.oneframework.car.dto.series.SearchDto;
import course.linkflower.link.oneframework.car.dto.series.UpdateDto;
import course.linkflower.link.oneframework.car.vo.series.SeriesVo;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;

public interface SeriesService {
    Result<SeriesVo> add(AddDto addDto);

    Result delete(IdDto idDto);

    Result<SeriesVo> update(UpdateDto updateDto);

    Result<SeriesVo> getById(IdDto idDto);

    PageResult<SeriesVo> search(SearchDto searchDto);
}
