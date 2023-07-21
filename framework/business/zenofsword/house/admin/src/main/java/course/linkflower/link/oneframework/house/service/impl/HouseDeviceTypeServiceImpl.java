package course.linkflower.link.oneframework.house.service.impl;

import course.linkflower.link.oneframework.common.constant.BaseErrorContst;
import course.linkflower.link.oneframework.common.dto.base.TypeDto;
import course.linkflower.link.oneframework.house.consts.HouseConstant;
import course.linkflower.link.oneframework.house.model.HousePageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dao.HouseDeviceTypeMapper;
import course.linkflower.link.oneframework.house.dto.housedevicetype.*;
import course.linkflower.link.oneframework.house.model.HouseDeviceType;
import course.linkflower.link.oneframework.house.service.HouseDeviceTypeService;
import course.linkflower.link.oneframework.house.vo.housedevicetype.HouseDeviceTypeInfoVo;
import course.linkflower.link.oneframework.house.vo.housedevicetype.HouseDeviceTypeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseDeviceTypeServiceImpl implements HouseDeviceTypeService {
    @Autowired
    HouseDeviceTypeMapper houseDeviceTypeMapper;


    @Override
    public Result<HouseDeviceTypeVo> add(AddDto addDto) {
        HouseDeviceType houseDeviceType = addDto.toModel();
        if (houseDeviceTypeMapper.countByName(addDto.getName()) !=0){
           return Result.of(null,BaseErrorContst.BaseErrorTimeParamDuplicateError,BaseErrorContst.BaseMsgTimeParamsDuplicateError);
        }
        houseDeviceTypeMapper.save(houseDeviceType);
        return Result.succeed(new HouseDeviceTypeVo().loadFrom(houseDeviceType));
    }

    @Override
    public Result delete(DeleteDto deleteDto) {
        if (!StringUtils.isEmpty(deleteDto.getId()) && deleteDto.getIds()==null) {
            houseDeviceTypeMapper.delete(Long.parseLong(deleteDto.getId()));
        }
        if (StringUtils.isEmpty(deleteDto.getId()) && deleteDto.getIds()!=null) {
            houseDeviceTypeMapper.deleteAll(HouseConstant.stringToLong(deleteDto.getIds()));
        }
        return Result.succeed();
    }

    @Override
    public Result<HouseDeviceTypeVo> update(UpdateDto updateDto) {
        HouseDeviceType houseDeviceType = updateDto.toModel();
        houseDeviceTypeMapper.update(houseDeviceType);
        return Result.succeed(new HouseDeviceTypeVo().loadFrom(houseDeviceType));
    }

    @Override
    public Result<HouseDeviceTypeVo> getOne(SearchDto searchDto) {
        return Result.succeed(new HouseDeviceTypeVo().loadFrom(houseDeviceTypeMapper.getById(Long.parseLong(searchDto.getId()))));
    }

    @Override
    public HousePageResult<HouseDeviceTypeInfoVo> search(HousePageDto housePageDto) {
        List<HouseDeviceTypeInfoVo> houseDeviceTypeInfos;
        houseDeviceTypeInfos = houseDeviceTypeMapper.search(housePageDto);
        HousePageResult<HouseDeviceTypeInfoVo> housePageResult =new HousePageResult<>();
        housePageResult.setData(houseDeviceTypeInfos);
        housePageResult.setCount(houseDeviceTypeMapper.countAll());
        housePageResult.setPage(housePageDto.getPage());
        housePageResult.setPageSize(housePageDto.getPageSize());
        return housePageResult;
    }

    @Override
    public Result<List<HouseDeviceTypeInfoVo>> listByType(TypeDto typeDto) {
        return Result.succeed(houseDeviceTypeMapper.listByType(typeDto.getType()));
    }

}
