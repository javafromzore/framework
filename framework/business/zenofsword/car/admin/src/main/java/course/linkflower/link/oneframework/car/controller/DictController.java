package course.linkflower.link.oneframework.car.controller;

import course.linkflower.link.oneframework.car.dto.dict.AddDto;
import course.linkflower.link.oneframework.car.dto.dict.SearchDto;
import course.linkflower.link.oneframework.car.dto.dict.UpdateDto;
import course.linkflower.link.oneframework.car.service.DictService;
import course.linkflower.link.oneframework.car.vo.dict.DictVo;
import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.dto.base.TypeDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
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
@RequestMapping(ApisConstant.ApiV1+"/dictionary")
@RefreshScope
public class DictController {
    @Autowired
    private DictService dictService;
    @PostMapping("/add")
    public Result<DictVo> add(@RequestBody AddDto addDto){
        return dictService.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody IdDto idDto){
        return dictService.delete(idDto);
    }

    @PostMapping("/update")
    public Result<DictVo> update(@RequestBody UpdateDto updateDto){
        return dictService.update(updateDto);
    }

    @PostMapping("/listByType")
    public Result<List<DictVo>> listByType(@RequestBody TypeDto typeDto){
        return dictService.listByType(typeDto);
    }

    @PostMapping("/search")
    public PageResult<DictVo> search(@RequestBody SearchDto searchDto){
        return dictService.search(searchDto);
    }

    @PostMapping("/getById")
    public Result<DictVo> getById(@RequestBody IdDto idDto){
        return dictService.getById(idDto);
    }
}

