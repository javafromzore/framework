package course.linkflower.link.oneframework.house.service.impl;

import course.linkflower.link.oneframework.common.constant.BaseErrorContst;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dao.HouseHightlightInfoMapper;
import course.linkflower.link.oneframework.house.dto.housedevicetype.HousePageDto;
import course.linkflower.link.oneframework.house.dto.househighlightinfo.AddDto;
import course.linkflower.link.oneframework.house.dto.househighlightinfo.DeleteDto;
import course.linkflower.link.oneframework.house.dto.househighlightinfo.UpdateDto;
import course.linkflower.link.oneframework.house.model.HouseHightlightInfo;
import course.linkflower.link.oneframework.house.model.HousePageResult;
import course.linkflower.link.oneframework.house.service.HouseHightlightInfoService;
import course.linkflower.link.oneframework.house.vo.househightlightinfo.HouseHightlightInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseHightlightInfoServiceImpl implements HouseHightlightInfoService {
    @Autowired
    HouseHightlightInfoMapper houseHightlightInfoMapper;
    @Override
    public Result<HouseHightlightInfoVo> add(AddDto addDto) {
        HouseHightlightInfo houseHightlightInfo = addDto.toModel();
        if (houseHightlightInfoMapper.countByName(addDto.getName())!=0){
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,BaseErrorContst.BaseMsgTimeParamsDuplicateError);
        }
        houseHightlightInfoMapper.save(houseHightlightInfo);
        return Result.succeed(new HouseHightlightInfoVo().loadFrom(houseHightlightInfo));
    }

    @Override
    public Result delete(DeleteDto deleteDto) {
        if (!StringUtils.isEmpty(deleteDto.getId()) && deleteDto.getIds()==null) {
            houseHightlightInfoMapper.delete(Long.parseLong(deleteDto.getId()));
        }
        if (StringUtils.isEmpty(deleteDto.getId()) && deleteDto.getIds()!=null){
            houseHightlightInfoMapper.deleteAll(deleteDto.getIds());
        }
        return Result.succeed();
    }

    @Override
    public Result<HouseHightlightInfoVo> update(UpdateDto updateDto) {
        HouseHightlightInfo houseHightlightInfo = updateDto.toModel();
        if (houseHightlightInfoMapper.countByName(updateDto.getName())!=0){
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,BaseErrorContst.BaseMsgTimeParamsDuplicateError);
        }
        houseHightlightInfoMapper.update(houseHightlightInfo);
        return Result.succeed(new HouseHightlightInfoVo().loadFrom(houseHightlightInfo));
    }

    @Override
    public HousePageResult<HouseHightlightInfoVo> search(HousePageDto housePageDto) {
        List<HouseHightlightInfoVo>  houseHightlightInfoVos = houseHightlightInfoMapper.search(housePageDto);
        HousePageResult<HouseHightlightInfoVo> housePageResult =new HousePageResult<>();
        housePageResult.setData(houseHightlightInfoVos);
        housePageResult.setCount(houseHightlightInfoMapper.countAll());
        housePageResult.setPage(housePageDto.getPage());
        housePageResult.setPageSize(housePageDto.getPageSize());
        return housePageResult;
    }
}
