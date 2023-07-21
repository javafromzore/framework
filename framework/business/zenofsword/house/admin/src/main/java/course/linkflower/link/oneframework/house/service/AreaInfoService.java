package course.linkflower.link.oneframework.house.service;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.areainfo.*;
import course.linkflower.link.oneframework.house.vo.areainfo.AreaInfoVo;
import course.linkflower.link.oneframework.house.vo.areainfo.ShortAreaInfoVo;

import java.util.List;

public interface AreaInfoService {
    Result<AreaInfoVo> add(AddDto addDto);
    Result delete(DeleteDto deleteDto);
    Result<AreaInfoVo> update(UpdateDto updateDto);
    Result<AreaInfoVo> getById(SearchDto searchDto);
    Result<List<ShortAreaInfoVo>> searchByAdd(SearchByKey searchByKey);
}
