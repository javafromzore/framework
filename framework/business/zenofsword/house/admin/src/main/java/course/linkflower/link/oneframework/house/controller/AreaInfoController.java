package course.linkflower.link.oneframework.house.controller;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.areainfo.*;
import course.linkflower.link.oneframework.house.service.AreaInfoService;
import course.linkflower.link.oneframework.house.vo.areainfo.AreaInfoVo;
import course.linkflower.link.oneframework.house.vo.areainfo.ShortAreaInfoVo;
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
@RequestMapping("/areainfo")
@RefreshScope
public class AreaInfoController {
    @Autowired
    AreaInfoService areaInfoService;

    @PostMapping("/add")
    public Result<AreaInfoVo> add(@RequestBody AddDto addDto) {

        return areaInfoService.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteDto deleteDto) {
        return areaInfoService.delete(deleteDto);
    }

    @PostMapping("/update")
    public Result<AreaInfoVo> update(@RequestBody UpdateDto updateDto) {
        return areaInfoService.update(updateDto);
    }

    @PostMapping("/search")
    public Result<AreaInfoVo> search(@RequestBody SearchDto searchDto) {
        return areaInfoService.getById(searchDto);
    }
    @PostMapping("/searchByAdd")
    public Result<List<ShortAreaInfoVo>> listByType(@RequestBody SearchByKey searchByKey) {
        return areaInfoService.searchByAdd(searchByKey);
    }
}
