package course.linkflower.link.oneframework.car.controller;

import course.linkflower.link.oneframework.car.dto.series.AddDto;
import course.linkflower.link.oneframework.car.dto.series.SearchDto;
import course.linkflower.link.oneframework.car.dto.series.UpdateDto;
import course.linkflower.link.oneframework.car.vo.series.SeriesVo;
import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.service.SeriesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1+"/carinfor")
@RefreshScope
public class SeriesController {
    @Autowired
    private SeriesService seriesService;
    @PostMapping("/add")
    public Result<SeriesVo> add(@RequestBody AddDto addDto){
        return seriesService.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody IdDto idDto){
        return seriesService.delete(idDto);
    }

    @PostMapping("/update")
    public Result<SeriesVo> update(@RequestBody UpdateDto updateDto){
        return seriesService.update(updateDto);
    }

    @PostMapping("/getById")
    public Result<SeriesVo> getById(@RequestBody IdDto idDto){
        return seriesService.getById(idDto);
    }

    @PostMapping("/search")
    public PageResult<SeriesVo> search(@RequestBody SearchDto searchDto){
        return seriesService.search(searchDto);
    }
}
