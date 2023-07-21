package course.linkflower.link.oneframework.house.controller;

import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.housedevice.AddDto;
import course.linkflower.link.oneframework.house.dto.housedevice.DeleteDto;
import course.linkflower.link.oneframework.house.dto.housedevice.SearchDto;
import course.linkflower.link.oneframework.house.dto.housedevice.UpdateDto;
import course.linkflower.link.oneframework.house.dto.housedevicetype.AddMoreDto;
import course.linkflower.link.oneframework.house.service.HouseDeviceService;
import course.linkflower.link.oneframework.house.vo.housedevice.HouseDeviceVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1 + "/housedevice")
@RefreshScope
public class HouseDeviceController {
    @Autowired
    HouseDeviceService houseDeviceService;

    @PostMapping("/add")
    public Result<HouseDeviceVo> add(@RequestBody AddDto addDto) {
        return houseDeviceService.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteDto deleteDto) {
        return houseDeviceService.delete(deleteDto);
    }

    @PostMapping("/update")
    public Result<HouseDeviceVo> update(@RequestBody UpdateDto updateDto) {
        return houseDeviceService.update(updateDto);
    }

    @PostMapping("/search")
    public Result<HouseDeviceVo> search(@RequestBody SearchDto searchDto) {
        return houseDeviceService.getById(searchDto);
    }

    @PostMapping("/addAll")
    public Result addAll(@RequestBody AddMoreDto addMoreDto) {
        return houseDeviceService.addAll(addMoreDto);
    }
}
