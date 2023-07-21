package course.linkflower.link.oneframework.car.controller;

import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.dto.usedcar.SearchDto;
import course.linkflower.link.oneframework.car.dto.usedcar.UsedCarDto;
import course.linkflower.link.oneframework.car.dto.usedcar.AddDto;
import course.linkflower.link.oneframework.car.service.UsedCarService;
import course.linkflower.link.oneframework.car.vo.usedcar.UsedCarVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1+"/usedcar")
@RefreshScope
public class UsedCarController {
    @Autowired
    private UsedCarService usedCarService;
    @PostMapping("add")
    public Result<UsedCarVo> add(@RequestBody AddDto addDto){
        return usedCarService.add(addDto);
    }

    @PostMapping("delete")
    public Result delete(@RequestBody IdDto idDto){
        return usedCarService.delete(idDto);
    }

    @PostMapping("update")
    public Result<UsedCarVo> update(@RequestBody UsedCarDto usedCarDto){
        return usedCarService.update(usedCarDto);
    }

    @PostMapping("getById")
    public Result<UsedCarVo> getById(@RequestBody IdDto idDto){
        return usedCarService.getById(idDto);
    }

    @PostMapping("/Search")
    public PageResult<UsedCarVo> Search(@RequestBody SearchDto searchDto){
        return usedCarService.search(searchDto);
    }
}
