package course.linkflower.link.oneframework.car.service;

import course.linkflower.link.oneframework.car.dto.config.AddDto;
import course.linkflower.link.oneframework.car.dto.config.SearchDto;
import course.linkflower.link.oneframework.car.dto.config.UpdateDto;
import course.linkflower.link.oneframework.car.vo.config.ConfigVo;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;

public interface ConfigService {
    Result<ConfigVo> add(AddDto addDto);

    Result delete(IdDto idDto);

    Result<ConfigVo> update(UpdateDto updateDto);

    PageResult<ConfigVo> search(SearchDto searchByDto);

    Result<ConfigVo> getById(IdDto idDto);
}
