package course.linkflower.link.oneframework.house.service.impl;

import course.linkflower.link.oneframework.common.constant.BaseErrorContst;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dao.HouseDeviceMapper;
import course.linkflower.link.oneframework.house.dto.housedevice.AddDto;
import course.linkflower.link.oneframework.house.dto.housedevice.DeleteDto;
import course.linkflower.link.oneframework.house.dto.housedevice.SearchDto;
import course.linkflower.link.oneframework.house.dto.housedevice.UpdateDto;
import course.linkflower.link.oneframework.house.dto.housedevicetype.AddMoreDto;
import course.linkflower.link.oneframework.house.model.HouseDevice;
import course.linkflower.link.oneframework.house.service.HouseDeviceService;
import course.linkflower.link.oneframework.house.vo.housedevice.HouseDeviceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseDeviceServiceImpl implements HouseDeviceService {
    @Autowired
    HouseDeviceMapper houseDeviceMapper;

    @Override
    public Result<HouseDeviceVo> add(AddDto addDto) {
        HouseDevice houseDevice = addDto.toModel();
        if (houseDeviceMapper.countRepeat(Long.parseLong(addDto.getRentHouseInfoId()),Long.parseLong(addDto.getHouseDeviceTypeId()))!=0){
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,BaseErrorContst.BaseMsgTimeParamsDuplicateError);
        }
        houseDeviceMapper.save(houseDevice);
        return Result.succeed(new HouseDeviceVo().loadFrom(houseDevice));
    }

    @Override
    public Result delete(DeleteDto deleteDto) {
        houseDeviceMapper.delete(Long.parseLong(deleteDto.getId()));
        return Result.succeed();
    }

    @Override
    public Result<HouseDeviceVo> update(UpdateDto updateDto) {
        HouseDevice houseDevice = updateDto.toModel();
        if (houseDeviceMapper.countRepeat(Long.parseLong(updateDto.getRentHouseInfoId()),Long.parseLong(updateDto.getHouseDeviceTypeId()))!=0){
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,BaseErrorContst.BaseMsgTimeParamsDuplicateError);
        }
        houseDeviceMapper.update(houseDevice);
        return Result.succeed(new HouseDeviceVo().loadFrom(houseDevice));
    }

    @Override
    public Result<HouseDeviceVo> getById(SearchDto searchDto) {
        return Result.succeed(new HouseDeviceVo().loadFrom(houseDeviceMapper.getById(Long.parseLong(searchDto.getId()))));
    }


    @Override
    public Result addAll(AddMoreDto addMoreDto) {
        if (addMoreDto.getDeviceIds()==null){
            return Result.of(null,BaseErrorContst.BaseErrorClientNoChooseError,BaseErrorContst.BaseMsgClientNoChooseError);
        }
        houseDeviceMapper.saves(Long.parseLong(addMoreDto.getHouseId()), addMoreDto.getDeviceIds());
        return Result.succeed();
    }
}
