package course.linkflower.link.oneframework.house.controller;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.househightlight.AddDto;
import course.linkflower.link.oneframework.house.dto.househightlight.DeleteDto;
import course.linkflower.link.oneframework.house.dto.househightlight.SearchDto;
import course.linkflower.link.oneframework.house.dto.househightlight.UpdateDto;
import course.linkflower.link.oneframework.house.service.HouseHighlightService;
import course.linkflower.link.oneframework.house.vo.househighlight.HouseHighlightVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/househighlight")
@RefreshScope
public class HouseHighlightController {
    @Autowired
    HouseHighlightService houseHighlightService;

    @PostMapping("/add")
    public Result<HouseHighlightVo> add(@RequestBody AddDto addDto) {
        return houseHighlightService.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteDto deleteDto) {
        return houseHighlightService.delete(deleteDto);
    }

    @PostMapping("/update")
    public Result<HouseHighlightVo> update(@RequestBody UpdateDto updateDto) {
        return houseHighlightService.update(updateDto);
    }

    @PostMapping("/search")
    public Result<HouseHighlightVo> search(@RequestBody SearchDto searchDto) {
        return houseHighlightService.getById(searchDto);
    }
}
