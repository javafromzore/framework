package course.linkflower.link.oneframework.car.service;

import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.dto.usedcarphoto.SearchDto;
import course.linkflower.link.oneframework.car.dto.usedcarphoto.UpdateDto;
import course.linkflower.link.oneframework.car.dto.usedcarphoto.AddDto;
import course.linkflower.link.oneframework.car.vo.usedcarphoto.UsedCarPhotoVo;

import java.util.List;

public interface UsedCarPhotoService {

    Result<UsedCarPhotoVo> add(AddDto addDto);

    Result delete(IdDto idDto);

    Result<UsedCarPhotoVo> update(UpdateDto updateDto);

    PageResult<UsedCarPhotoVo> search(SearchDto searchDto);

    Result<UsedCarPhotoVo> getById(IdDto idDto);

    Result<List<UsedCarPhotoVo>> listByUsedCarId(IdDto idDto);
}
