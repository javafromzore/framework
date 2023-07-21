package course.linkflower.link.oneframework.house.controller;

import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.housedevicetype.HousePageDto;
import course.linkflower.link.oneframework.house.dto.househighlightinfo.*;
import course.linkflower.link.oneframework.house.model.HousePageResult;
import course.linkflower.link.oneframework.house.service.HouseHightlightInfoService;
import course.linkflower.link.oneframework.house.vo.househightlightinfo.HouseHightlightInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1+"/househighlightinfo")
@RefreshScope
public class HouseHightlightInfoController {
    @Autowired
    HouseHightlightInfoService houseHightlightInfoService;

    @PostMapping("/add")
    public Result<HouseHightlightInfoVo> add(@RequestBody AddDto addDto) {
        return houseHightlightInfoService.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteDto deleteDto) {
        return houseHightlightInfoService.delete(deleteDto);
    }

    @PostMapping("/update")
    public Result<HouseHightlightInfoVo> update(@RequestBody UpdateDto updateDto) {
        return houseHightlightInfoService.update(updateDto);
    }

    @PostMapping("/search")
    public HousePageResult<HouseHightlightInfoVo> search(@RequestBody HousePageDto housePageDto) {
        return houseHightlightInfoService.search(housePageDto);
    }
}
