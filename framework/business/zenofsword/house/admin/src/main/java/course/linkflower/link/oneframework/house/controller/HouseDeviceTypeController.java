package course.linkflower.link.oneframework.house.controller;

import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.dto.base.TypeDto;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.housedevicetype.*;
import course.linkflower.link.oneframework.house.model.HousePageResult;
import course.linkflower.link.oneframework.house.service.HouseDeviceTypeService;
import course.linkflower.link.oneframework.house.vo.housedevicetype.HouseDeviceTypeInfoVo;
import course.linkflower.link.oneframework.house.vo.housedevicetype.HouseDeviceTypeVo;
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
@RequestMapping(ApisConstant.ApiV1 + "/housedevicetype")
@RefreshScope
public class HouseDeviceTypeController {
    @Autowired
    HouseDeviceTypeService houseDeviceTypeService;
    @PostMapping("/add")
    public Result<HouseDeviceTypeVo> add(@RequestBody AddDto addDto) {
        return houseDeviceTypeService.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteDto deleteDto) {
        return houseDeviceTypeService.delete(deleteDto);
    }

    @PostMapping("/update")
    public Result<HouseDeviceTypeVo> update(@RequestBody UpdateDto updateDto) {
        return houseDeviceTypeService.update(updateDto);
    }

    @PostMapping("/getById")
    public Result<HouseDeviceTypeVo> getOne(@RequestBody SearchDto searchDto) {
        return houseDeviceTypeService.getOne(searchDto);
    }
    @PostMapping("/search")
    public HousePageResult<HouseDeviceTypeInfoVo> search(@RequestBody HousePageDto housePageDto) {
        return houseDeviceTypeService.search(housePageDto);
    }

    @PostMapping("/listByType")
    public Result<List<HouseDeviceTypeInfoVo>> listByType(@RequestBody TypeDto typeDto) {
        return houseDeviceTypeService.listByType(typeDto);
    }

}
