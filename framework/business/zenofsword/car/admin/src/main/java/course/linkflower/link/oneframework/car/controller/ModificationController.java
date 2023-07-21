package course.linkflower.link.oneframework.car.controller;

import course.linkflower.link.oneframework.car.service.ModificationService;
import course.linkflower.link.oneframework.car.vo.modification.ModificationVo;
import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.dto.modification.AddDto;
import course.linkflower.link.oneframework.car.dto.modification.SearchDto;
import course.linkflower.link.oneframework.car.dto.modification.UpdateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1+"/usedcarconfig")
@RefreshScope
public class ModificationController {
    @Autowired
    private ModificationService modificationService;
    @PostMapping("/add")
    public Result<ModificationVo> add(@RequestBody AddDto addDto){
        return modificationService.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody IdDto idDto){
        return modificationService.delete(idDto);
    }

    @PostMapping("/update")
    public Result<ModificationVo> update(@RequestBody UpdateDto updateDto){
        return modificationService.update(updateDto);
    }

    @PostMapping("/search")
    public PageResult<ModificationVo> search(@RequestBody SearchDto searchDto){
        return modificationService.search(searchDto);
    }
}
