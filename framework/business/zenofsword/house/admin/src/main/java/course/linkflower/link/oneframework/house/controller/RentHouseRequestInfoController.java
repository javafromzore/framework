package course.linkflower.link.oneframework.house.controller;

import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.housedevicetype.HousePageDto;
import course.linkflower.link.oneframework.house.dto.renthouserequestinfo.AddDto;
import course.linkflower.link.oneframework.house.dto.renthouserequestinfo.DeleteDto;
import course.linkflower.link.oneframework.house.dto.renthouserequestinfo.UpdateDto;
import course.linkflower.link.oneframework.house.model.HousePageResult;
import course.linkflower.link.oneframework.house.service.RentHouseRequestInfoService;
import course.linkflower.link.oneframework.house.vo.renthouserequestinfo.RentHouseRequestInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1+"/houserequestinfo")
@RefreshScope
public class RentHouseRequestInfoController {
    @Autowired
    RentHouseRequestInfoService rentHouseRequestInfoService;
    @PostMapping("/add")
    public Result<RentHouseRequestInfoVo> add(@RequestBody AddDto addDto) {
        return rentHouseRequestInfoService.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteDto deleteDto) {
        return rentHouseRequestInfoService.delete(deleteDto);
    }

    @PostMapping("/update")
    public Result<RentHouseRequestInfoVo> update(@RequestBody UpdateDto updateDto) {
        return rentHouseRequestInfoService.update(updateDto);
    }

    @PostMapping("/search")
    public HousePageResult<RentHouseRequestInfoVo> search(@RequestBody HousePageDto housePageDto) {
        return rentHouseRequestInfoService.search(housePageDto);
    }
}
