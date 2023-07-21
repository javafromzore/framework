package course.linkflower.link.oneframework.house.service.impl;

import course.linkflower.link.oneframework.common.constant.BaseErrorContst;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dao.HouseHighlightMapper;
import course.linkflower.link.oneframework.house.dto.househightlight.AddDto;
import course.linkflower.link.oneframework.house.dto.househightlight.DeleteDto;
import course.linkflower.link.oneframework.house.dto.househightlight.SearchDto;
import course.linkflower.link.oneframework.house.dto.househightlight.UpdateDto;
import course.linkflower.link.oneframework.house.model.HouseHighlight;
import course.linkflower.link.oneframework.house.service.HouseHighlightService;
import course.linkflower.link.oneframework.house.vo.househighlight.HouseHighlightVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseHighlightServiceImpl implements HouseHighlightService {
    @Autowired
    HouseHighlightMapper houseHighlightMapper;

    @Override
    public Result<HouseHighlightVo> add(AddDto addDto) {
        HouseHighlight houseHighlight = addDto.toModel();
        if (houseHighlightMapper.countRepeat(Long.parseLong(addDto.getRentHouseInfoId()),Long.parseLong(addDto.getHighlightId()))!=0) {
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,BaseErrorContst.BaseMsgTimeParamsDuplicateError);
        }
        houseHighlightMapper.save(houseHighlight);
        return Result.succeed(new HouseHighlightVo().loadFrom(houseHighlight));
    }

    @Override
    public Result delete(DeleteDto deleteDto) {
        houseHighlightMapper.delete(Long.parseLong(deleteDto.getId()));
        return Result.succeed();
    }

    @Override
    public Result<HouseHighlightVo> update(UpdateDto updateDto) {
        HouseHighlight houseHighlight = updateDto.toModel();
        if (houseHighlightMapper.countRepeat(Long.parseLong(updateDto.getRentHouseInfoId()),Long.parseLong(updateDto.getHighlightId()))!=0) {
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,BaseErrorContst.BaseMsgTimeParamsDuplicateError);
        }
        houseHighlightMapper.update(houseHighlight);
        return Result.succeed(new HouseHighlightVo().loadFrom(houseHighlight));
    }

    @Override
    public Result<HouseHighlightVo> getById(SearchDto searchDto) {
        return Result.succeed(new HouseHighlightVo().loadFrom(houseHighlightMapper.getById(Long.parseLong(searchDto.getId()))));
    }
}
