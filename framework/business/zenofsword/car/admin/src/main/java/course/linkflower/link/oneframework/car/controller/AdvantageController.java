package course.linkflower.link.oneframework.car.controller;

import course.linkflower.link.oneframework.car.service.AdvantageService;
import course.linkflower.link.oneframework.car.vo.advantage.AdvantageVo;
import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.dto.advantage.AddDto;
import course.linkflower.link.oneframework.car.dto.advantage.SearchDto;
import course.linkflower.link.oneframework.car.dto.advantage.UpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1+"/caradvantage")
@RefreshScope
public class AdvantageController {
    @Autowired
    private AdvantageService advantageService;
    @PostMapping("/add")
    public Result<AdvantageVo> add(@RequestBody AddDto AddDto){
        return advantageService.add(AddDto);
    }

    @PostMapping("/getById")
    public Result<AdvantageVo> getById(@RequestBody IdDto idDto){
        return advantageService.getById(idDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody IdDto idDto){
        return advantageService.delete(idDto);
    }

    @PostMapping("/update")
    public Result<AdvantageVo> update(@RequestBody UpdateDto updateDto){
        return advantageService.update(updateDto);
    }

    @PostMapping("/search")
    public PageResult<AdvantageVo> search(SearchDto searchDto){
        return advantageService.search(searchDto);
    }
}
