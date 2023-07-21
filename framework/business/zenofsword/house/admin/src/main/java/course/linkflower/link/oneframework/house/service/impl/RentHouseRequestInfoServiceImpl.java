package course.linkflower.link.oneframework.house.service.impl;

import course.linkflower.link.oneframework.common.constant.BaseErrorContst;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dao.RentHouseRequestInfoMapper;
import course.linkflower.link.oneframework.house.dto.housedevicetype.HousePageDto;
import course.linkflower.link.oneframework.house.dto.renthouserequestinfo.AddDto;
import course.linkflower.link.oneframework.house.dto.renthouserequestinfo.DeleteDto;
import course.linkflower.link.oneframework.house.dto.renthouserequestinfo.UpdateDto;
import course.linkflower.link.oneframework.house.model.HousePageResult;
import course.linkflower.link.oneframework.house.model.RentHouseRequestInfo;
import course.linkflower.link.oneframework.house.service.RentHouseRequestInfoService;
import course.linkflower.link.oneframework.house.vo.renthouserequestinfo.RentHouseRequestInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentHouseRequestInfoServiceImpl implements RentHouseRequestInfoService {
    @Autowired
    RentHouseRequestInfoMapper rentHouseRequestInfoMapper;
    @Override
    public Result<RentHouseRequestInfoVo> add(AddDto addDto) {
        RentHouseRequestInfo rentHouseRequestInfo = addDto.toModel();
        if (rentHouseRequestInfoMapper.countByName(addDto.getName())!=0){
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,BaseErrorContst.BaseMsgTimeParamsDuplicateError);
        }
        rentHouseRequestInfoMapper.save(rentHouseRequestInfo);
        return Result.succeed(new RentHouseRequestInfoVo().loadFrom(rentHouseRequestInfo));
    }

    @Override
    public Result delete(DeleteDto deleteDto) {
        if (!StringUtils.isEmpty(deleteDto.getId()) && deleteDto.getIds()==null) {
            rentHouseRequestInfoMapper.delete(Long.parseLong(deleteDto.getId()));
        }
        if (StringUtils.isEmpty(deleteDto.getId()) && deleteDto.getIds()!=null){
            rentHouseRequestInfoMapper.deleteAll(deleteDto.getIds());
        }
        return Result.succeed();
    }

    @Override
    public Result<RentHouseRequestInfoVo> update(UpdateDto updateDto) {
        RentHouseRequestInfo rentHouseRequestInfo = updateDto.toModel();
        if (rentHouseRequestInfoMapper.countByName(updateDto.getName())!=0){
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,BaseErrorContst.BaseMsgTimeParamsDuplicateError);
        }
        rentHouseRequestInfoMapper.update(rentHouseRequestInfo);
        return Result.succeed(new RentHouseRequestInfoVo().loadFrom(rentHouseRequestInfo));
    }

    @Override
    public HousePageResult<RentHouseRequestInfoVo> search(HousePageDto housePageDto) {
        List<RentHouseRequestInfoVo> rentHouseRequestInfoVos = rentHouseRequestInfoMapper.search(housePageDto);
        HousePageResult housePageResult = new HousePageResult<>();
        housePageResult.setData(rentHouseRequestInfoVos);
        housePageResult.setCount(rentHouseRequestInfoMapper.countAll());
        housePageResult.setPage(housePageDto.getPage());
        housePageResult.setPageSize(housePageDto.getPageSize());
        return housePageResult;
    }
}
