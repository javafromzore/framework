package course.linkflower.link.oneframework.house.controller;

import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.base.IdDto;
import course.linkflower.link.oneframework.house.dto.housedevicetype.HousePageDto;
import course.linkflower.link.oneframework.house.dto.housedictionary.*;
import course.linkflower.link.oneframework.house.model.HousePageResult;
import course.linkflower.link.oneframework.house.service.HouseDictionaryService;
import course.linkflower.link.oneframework.house.vo.housedictionary.HouseDictionaryVo;
import course.linkflower.link.oneframework.house.vo.housedictionary.ShortHouseDictionaryVo;
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
@RequestMapping(ApisConstant.ApiV1+"/housedictionary")
@RefreshScope
public class HouseDictionaryController {
    @Autowired
    HouseDictionaryService houseDictionaryService;
    @PostMapping("/add")
    public Result<HouseDictionaryVo> add(@RequestBody AddDto addDto) {
        return houseDictionaryService.add(addDto);
    }


    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteDto deleteDto) {
        return houseDictionaryService.delete(deleteDto);
    }

    @PostMapping("/update")
    public Result<HouseDictionaryVo> update(@RequestBody UpdateDto updateDto) {
        return houseDictionaryService.update(updateDto);
    }
    @PostMapping("/search")
    public HousePageResult<HouseDictionaryVo> search(@RequestBody HousePageDto housePageDto) {
        return houseDictionaryService.search(housePageDto);
    }
    @PostMapping("/listByType")
    public Result<List<ShortHouseDictionaryVo>> listByType(@RequestBody ChooseDto chooseDto) {
        return houseDictionaryService.listType(chooseDto);
    }

    @PostMapping("/getById")
    public Result<HouseDictionaryVo> getById(@RequestBody IdDto idDto) {
        return houseDictionaryService.getById(idDto);
    }
}
