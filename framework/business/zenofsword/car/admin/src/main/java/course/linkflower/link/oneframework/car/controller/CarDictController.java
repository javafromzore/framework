package course.linkflower.link.oneframework.car.controller;

import course.linkflower.link.oneframework.car.dto.cardict.AddDto;
import course.linkflower.link.oneframework.car.dto.cardict.SearchDto;
import course.linkflower.link.oneframework.car.dto.cardict.UpdateDto;
import course.linkflower.link.oneframework.car.service.CarDictService;
import course.linkflower.link.oneframework.car.vo.cardict.CarDictInfoVo;
import course.linkflower.link.oneframework.car.vo.cardict.CarDictVo;
import course.linkflower.link.oneframework.car.vo.cardict.SearchVo;
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
@RequestMapping(ApisConstant.ApiV1+"/cardict")
@RefreshScope
public class CarDictController {
    @Autowired
    private CarDictService carDictService;
    @PostMapping("/add")
    public Result<CarDictVo> add(@RequestBody AddDto addDto){
        return carDictService.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody IdDto idDto){
        return carDictService.delete(idDto);
    }

    @PostMapping("/update")
    public Result<CarDictVo> update(@RequestBody UpdateDto updateDto){
        return carDictService.update(updateDto);
    }

    @PostMapping("/search")
    public PageResult<SearchVo> search(@RequestBody SearchDto searchDto){
        return carDictService.search(searchDto);
    }

    @PostMapping("/listInfoByType")
    public Result<List<CarDictInfoVo>> listInfoByType(@RequestBody TypeDto typeDto){
        return carDictService.listInfosByType(typeDto);
    }

    @PostMapping("/getById")
    public Result<CarDictVo> getById(@RequestBody IdDto idDto){
        return carDictService.getById(idDto);
    }
}
