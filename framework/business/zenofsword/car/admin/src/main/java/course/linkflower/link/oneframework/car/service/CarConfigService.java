package course.linkflower.link.oneframework.car.service;

import course.linkflower.link.oneframework.car.vo.carconfig.CarConfigVo;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.dto.carconfig.DeleteByTargetDto;
import course.linkflower.link.oneframework.car.dto.carconfig.SearchDto;
import course.linkflower.link.oneframework.car.dto.carconfig.UpdateDto;

public interface CarConfigService {
    Result delete(IdDto idDto);

    Result<CarConfigVo> update(UpdateDto updateDto);

    PageResult<CarConfigVo> search(SearchDto searchDto);

    void deleteByTarget(DeleteByTargetDto deleteByTargetDto);
}
