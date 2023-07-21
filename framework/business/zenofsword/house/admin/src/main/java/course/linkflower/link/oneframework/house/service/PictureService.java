package course.linkflower.link.oneframework.house.service;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.picture.AddDto;
import course.linkflower.link.oneframework.house.dto.picture.DeleteDto;
import course.linkflower.link.oneframework.house.dto.picture.SearchDto;
import course.linkflower.link.oneframework.house.dto.picture.UpdateDto;
import course.linkflower.link.oneframework.house.vo.picture.PictureVo;

public interface PictureService {
    Result<PictureVo> add(AddDto addDto);
    Result delete(DeleteDto deleteDto);
    Result<PictureVo> update(UpdateDto updateDto);
    Result<PictureVo> getById(SearchDto searchDto);
}
