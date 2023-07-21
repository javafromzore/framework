package course.linkflower.link.oneframework.house.controller;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.picture.AddDto;
import course.linkflower.link.oneframework.house.dto.picture.DeleteDto;
import course.linkflower.link.oneframework.house.dto.picture.SearchDto;
import course.linkflower.link.oneframework.house.dto.picture.UpdateDto;
import course.linkflower.link.oneframework.house.service.PictureService;
import course.linkflower.link.oneframework.house.vo.picture.PictureVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/picture")
@RefreshScope
public class PictureController {
    @Autowired
    PictureService pictureService;
    @PostMapping("/add")
    public Result<PictureVo> add(@RequestBody AddDto addDto) {
        return pictureService.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteDto deleteDto) {
        return pictureService.delete(deleteDto);
    }

    @PostMapping("/update")
    public Result<PictureVo> update(@RequestBody UpdateDto updateDto) {
        return pictureService.update(updateDto);
    }

    @PostMapping("/search")
    public Result<PictureVo> search(@RequestBody SearchDto searchDto) {
        return pictureService.getById(searchDto);
    }
}
