package course.linkflower.link.oneframework.car.controller;

import course.linkflower.link.oneframework.car.service.CarConfigService;
import course.linkflower.link.oneframework.car.vo.carconfig.CarConfigVo;
import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.dto.carconfig.DeleteByTargetDto;
import course.linkflower.link.oneframework.car.dto.carconfig.SearchDto;
import course.linkflower.link.oneframework.car.dto.carconfig.UpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1+"/carconfig")
@RefreshScope
public class CarConfigController {
    @Autowired
    private CarConfigService carConfigService;

    @PostMapping("/delete")
    public Result delete(@RequestBody IdDto idDto){
        return carConfigService.delete(idDto);
    }

    @PostMapping("/update")
    public Result<CarConfigVo> update(@RequestBody UpdateDto updateDto){
        return carConfigService.update(updateDto);
    }

    @PostMapping("/search")
    public PageResult<CarConfigVo> search(@RequestBody SearchDto searchDto){
        return carConfigService.search(searchDto);
    }

    @PostMapping("/deleteByTarget")
    public Result deleteByTarget(@RequestBody DeleteByTargetDto deleteByTargetDto){
        carConfigService.deleteByTarget(deleteByTargetDto);
        return Result.succeed();
    }
}