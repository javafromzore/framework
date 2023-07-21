package course.linkflower.link.oneframework.house.service.impl;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dao.PictureMapper;
import course.linkflower.link.oneframework.house.dto.picture.AddDto;
import course.linkflower.link.oneframework.house.dto.picture.DeleteDto;
import course.linkflower.link.oneframework.house.dto.picture.SearchDto;
import course.linkflower.link.oneframework.house.dto.picture.UpdateDto;
import course.linkflower.link.oneframework.house.model.Picture;
import course.linkflower.link.oneframework.house.service.PictureService;
import course.linkflower.link.oneframework.house.vo.picture.PictureVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    PictureMapper pictureMapper;

    @Override
    public Result<PictureVo> add(AddDto addDto) {
        Picture picture = addDto.toModel();
        pictureMapper.save(picture);
        return Result.succeed(new PictureVo().loadFrom(picture));
    }

    @Override
    public Result delete(DeleteDto deleteDto) {
        pictureMapper.delete(Long.parseLong(deleteDto.getId()));
        return Result.succeed();
    }

    @Override
    public Result<PictureVo> update(UpdateDto updateDto) {
        Picture picture = updateDto.toModel();
        pictureMapper.update(picture);
        return Result.succeed(new PictureVo().loadFrom(picture));
    }

    @Override
    public Result<PictureVo> getById(SearchDto searchDto) {
        return Result.succeed(new PictureVo().loadFrom(pictureMapper.getById(Long.parseLong(searchDto.getId()))));
    }
}
