package course.linkflower.link.oneframework.car.controller;

import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.dto.usedcarphoto.SearchDto;
import course.linkflower.link.oneframework.car.dto.usedcarphoto.UpdateDto;
import course.linkflower.link.oneframework.car.dto.usedcarphoto.AddDto;
import course.linkflower.link.oneframework.car.service.UsedCarPhotoService;
import course.linkflower.link.oneframework.car.vo.usedcarphoto.UsedCarPhotoVo;
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
@RequestMapping(ApisConstant.ApiV1+"/usedcarphoto")
@RefreshScope
public class UsedCarPhotoController {
    @Autowired
    private UsedCarPhotoService usedCarPhotoService;
    @PostMapping("/add")
    public Result<UsedCarPhotoVo> add(@RequestBody AddDto addDto){
        return usedCarPhotoService.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody IdDto idDto){
        return usedCarPhotoService.delete(idDto);
    }

    @PostMapping("/update")
    public Result<UsedCarPhotoVo> update(@RequestBody UpdateDto updateDto){
        return usedCarPhotoService.update(updateDto);
    }

    @PostMapping("/listByUsedCarId")
    public Result<List<UsedCarPhotoVo>> listByUsedCarId(@RequestBody IdDto idDto){
        return usedCarPhotoService.listByUsedCarId(idDto);
    }

    @PostMapping("/search")
    public PageResult<UsedCarPhotoVo> search(@RequestBody SearchDto searchDto){
        return usedCarPhotoService.search(searchDto);
    }

    @PostMapping("/getById")
    public Result<UsedCarPhotoVo> getById(@RequestBody IdDto idDto){
        return usedCarPhotoService.getById(idDto);
    }
}
