package course.linkflower.link.oneframework.car.service;

import course.linkflower.link.oneframework.car.dto.patternphoto.UpdateDto;
import course.linkflower.link.oneframework.car.vo.patternphoto.PatternPhotoVo;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.dto.patternphoto.SearchDto;
import course.linkflower.link.oneframework.car.dto.patternphoto.AddDto;

import java.util.List;

public interface PatternPhotoService {

    Result<PatternPhotoVo> add(AddDto addDto);

    Result delete(IdDto idDto);

    Result<PatternPhotoVo> update(UpdateDto updateDto);

    Result<List<PatternPhotoVo>> listByPatternId(IdDto idDto);

    PageResult<PatternPhotoVo> search(SearchDto searchDto);
}
