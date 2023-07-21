package course.linkflower.link.oneframework.car.controller;

import course.linkflower.link.oneframework.car.dto.pattern.AddDto;
import course.linkflower.link.oneframework.car.service.PatternService;
import course.linkflower.link.oneframework.car.vo.pattern.PatternDetailVo;
import course.linkflower.link.oneframework.car.vo.pattern.PatternVo;
import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.dto.pattern.SearchDto;
import course.linkflower.link.oneframework.car.dto.pattern.UpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1+"/pattern")
@RefreshScope
public class PatternController {
//    @Value("${value.test.str}")
    @Autowired
    private PatternService patternService;
        @PostMapping("/add")
    public Result<PatternVo> add(@RequestBody AddDto addDto){
        return Result.succeed(patternService.add(addDto));
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody IdDto idDto){
            patternService.delete(idDto);
            return Result.succeed();
    }

    @PostMapping("/update")
    public Result<PatternVo> update(@RequestBody UpdateDto updateDto){
        return Result.succeed(patternService.update(updateDto));
    }

    @PostMapping("/getById")
    public Result<PatternVo> getById(@RequestBody IdDto idDto){
        return Result.succeed(patternService.getById(idDto));
    }

    @PostMapping("/search")
    public PageResult<PatternVo> search(@RequestBody SearchDto searchDto){
            return patternService.search(searchDto);
    }

    @PostMapping("/detail")
    public Result<PatternDetailVo> detail(@RequestBody IdDto idDto){
        return Result.succeed(patternService.detail(idDto));
    }
}
