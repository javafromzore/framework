package course.linkflower.link.oneframework.house.service;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.housedevice.AddDto;
import course.linkflower.link.oneframework.house.dto.housedevice.DeleteDto;
import course.linkflower.link.oneframework.house.dto.housedevice.SearchDto;
import course.linkflower.link.oneframework.house.dto.housedevice.UpdateDto;
import course.linkflower.link.oneframework.house.dto.housedevicetype.AddMoreDto;
import course.linkflower.link.oneframework.house.vo.housedevice.HouseDeviceVo;

public interface HouseDeviceService {
    Result<HouseDeviceVo> add(AddDto addDto);
    Result delete(DeleteDto deleteDto);
    Result<HouseDeviceVo> update(UpdateDto updateDto);
    Result<HouseDeviceVo> getById(SearchDto searchDto);

    Result addAll(AddMoreDto addMoreDto);
}
