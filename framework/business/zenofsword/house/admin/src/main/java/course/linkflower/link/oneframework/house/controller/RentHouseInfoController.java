package course.linkflower.link.oneframework.house.controller;

import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.base.IdDto;
import course.linkflower.link.oneframework.house.dto.housedevicetype.HousePageDto;
import course.linkflower.link.oneframework.house.dto.renthouseinfo.*;
import course.linkflower.link.oneframework.house.model.HousePageResult;
import course.linkflower.link.oneframework.house.service.RentHouseInfoService;
import course.linkflower.link.oneframework.house.service.RentHouseWholeInfoService;
import course.linkflower.link.oneframework.house.vo.renthouseinfo.HouseDetailsInfoVo;
import course.linkflower.link.oneframework.house.vo.renthouseinfo.RentHouseInfoVo;
import course.linkflower.link.oneframework.house.vo.renthouseinfo.ShortHouseInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1 +"/renthouse")
@RefreshScope
public class RentHouseInfoController {
    @Autowired
    RentHouseInfoService rentHouseInfoService;
    @PostMapping("/add")
    public Result<RentHouseInfoVo> add(@RequestBody AddDto addDto) {
        return rentHouseInfoService.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteDto deleteDto) {
        return rentHouseInfoService.delete(deleteDto);
    }

    @PostMapping("/update")
    public Result<RentHouseInfoVo> update(@RequestBody AddDto addDto) {
        return rentHouseInfoService.update(addDto);
    }
    @PostMapping("/getById")
    public Result<RentHouseInfoVo> getById(@RequestBody IdDto idDto) {
        return rentHouseInfoService.getById(idDto);
    }
    @PostMapping("/search")
    public HousePageResult<ShortHouseInfoVo> search(@RequestBody HousePageDto housePageDto) {
        return rentHouseInfoService.search(housePageDto);
    }
    @PostMapping("/details")
    public Result<HouseDetailsInfoVo> details(@RequestBody IdDto idDto) {
        return rentHouseInfoService.details(idDto);
    }
}
