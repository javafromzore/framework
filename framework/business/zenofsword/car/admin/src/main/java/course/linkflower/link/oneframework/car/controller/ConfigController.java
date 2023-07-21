package course.linkflower.link.oneframework.car.controller;

import course.linkflower.link.oneframework.car.dto.config.AddDto;
import course.linkflower.link.oneframework.car.dto.config.SearchDto;
import course.linkflower.link.oneframework.car.dto.config.UpdateDto;
import course.linkflower.link.oneframework.car.service.ConfigService;
import course.linkflower.link.oneframework.car.vo.config.ConfigVo;
import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1+"/carAttrib")
@RefreshScope
public class ConfigController {
    @Autowired
    private ConfigService carAttribService;
    @PostMapping("/add")
    public Result<ConfigVo> add(@RequestBody AddDto addDto){
        return carAttribService.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody IdDto idDto){
        return carAttribService.delete(idDto);
    }

    @PostMapping("/update")
    public Result<ConfigVo> update(@RequestBody UpdateDto updateDto){
        return carAttribService.update(updateDto);
    }

    @PostMapping("search")
    public PageResult<ConfigVo> search(@RequestBody SearchDto searchDto){
        return carAttribService.search(searchDto);
    }

    @PostMapping("getById")
    public Result<ConfigVo> getById(@RequestBody IdDto idDto){
        return carAttribService.getById(idDto);
    }
}
