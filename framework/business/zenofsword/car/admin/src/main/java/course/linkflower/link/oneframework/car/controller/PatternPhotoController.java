package course.linkflower.link.oneframework.car.controller;

import course.linkflower.link.oneframework.car.dto.patternphoto.UpdateDto;
import course.linkflower.link.oneframework.car.service.PatternPhotoService;
import course.linkflower.link.oneframework.car.vo.patternphoto.PatternPhotoVo;
import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.dto.patternphoto.SearchDto;
import course.linkflower.link.oneframework.car.dto.patternphoto.AddDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1+"/patternphoto")
@RefreshScope
public class PatternPhotoController {
    @Autowired
    private PatternPhotoService patternPhotoService;
    @PostMapping("/add")
    public Result<PatternPhotoVo> add(@RequestBody AddDto addDto){
        return patternPhotoService.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody IdDto idDto){
        return patternPhotoService.delete(idDto);
    }

    @PostMapping("/update")
    public Result<PatternPhotoVo> update(@RequestBody UpdateDto updateDto){
        return patternPhotoService.update(updateDto);
    }

    @PostMapping("/listByPatternId")
    public Result<List<PatternPhotoVo>> listByPatternId(@RequestBody IdDto idDto){
        return patternPhotoService.listByPatternId(idDto);
    }

    @PostMapping("/search")
    public PageResult<PatternPhotoVo> search(SearchDto SearchDto){
        return patternPhotoService.search(SearchDto);
    }
}
