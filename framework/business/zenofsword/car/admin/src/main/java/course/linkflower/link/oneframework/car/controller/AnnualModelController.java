package course.linkflower.link.oneframework.car.controller;

import course.linkflower.link.oneframework.car.service.AnnualModelServiceI;
import course.linkflower.link.oneframework.car.vo.annualmodel.AnnualModelVo;
import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.dto.annualmodel.AddDto;
import course.linkflower.link.oneframework.car.dto.annualmodel.SearchDto;
import course.linkflower.link.oneframework.car.dto.annualmodel.UpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1+"/carVersion")
@RefreshScope
public class AnnualModelController {
    @Autowired
    private AnnualModelServiceI annualModelServiceI;
    
    @PostMapping("/add")
    public Result<AnnualModelVo> add(@RequestBody AddDto addDto){
        return annualModelServiceI.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody IdDto idDto){
        return annualModelServiceI.delete(idDto);
    }

    @PostMapping("/update")
    public Result<AnnualModelVo> update(@RequestBody UpdateDto updateDto){
        return annualModelServiceI.update(updateDto);
    }
    @PostMapping("search")
    public PageResult<AnnualModelVo> search(@RequestBody SearchDto searchDto){
        return annualModelServiceI.search(searchDto);
    }

    @PostMapping("getById")
    public Result<AnnualModelVo> getById(@RequestBody IdDto idDto){
        return annualModelServiceI.getById(idDto);
    }
}
