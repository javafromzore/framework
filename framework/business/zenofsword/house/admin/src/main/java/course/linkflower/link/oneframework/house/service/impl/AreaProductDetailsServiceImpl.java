package course.linkflower.link.oneframework.house.service.impl;

import course.linkflower.link.oneframework.common.constant.BaseErrorContst;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dao.AreaProductDetailsMapper;
import course.linkflower.link.oneframework.house.dto.areaproductdetails.AddDto;
import course.linkflower.link.oneframework.house.dto.areaproductdetails.UpdateDto;
import course.linkflower.link.oneframework.house.dto.renthouserequestinfo.DeleteDto;
import course.linkflower.link.oneframework.house.model.AreaProductDetails;
import course.linkflower.link.oneframework.house.service.AreaProductDetailsService;
import course.linkflower.link.oneframework.house.vo.areaproductdetails.AreaProductDetailsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaProductDetailsServiceImpl implements AreaProductDetailsService {
    @Autowired
    AreaProductDetailsMapper areaProductDetailsMapper;

    @Override
    public Result<AreaProductDetailsVo> add(AddDto addDto) {
        AreaProductDetails areaProductDetails = addDto.toModel();
        if (areaProductDetailsMapper.countByAreaTargetType(areaProductDetails) != 0){
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,BaseErrorContst.BaseMsgTimeParamsDuplicateError);
        }
        areaProductDetailsMapper.save(areaProductDetails);
        return Result.succeed(new AreaProductDetailsVo().loadFrom(areaProductDetails));
    }

    @Override
    public Result delete(course.linkflower.link.oneframework.house.dto.areaproductdetails.DeleteDto deleteDto) {
        return null;
    }

    @Override
    public Result<AreaProductDetailsVo> update(UpdateDto updateDto) {
        AreaProductDetails areaProductDetails = updateDto.toModel();
        if (areaProductDetailsMapper.countByAreaTargetType(areaProductDetails) != 0){
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,BaseErrorContst.BaseMsgTimeParamsDuplicateError);
        }
        areaProductDetailsMapper.update(areaProductDetails);
        return Result.succeed(new AreaProductDetailsVo().loadFrom(areaProductDetails));
    }

    @Override
    public Result<AreaProductDetails> getById(DeleteDto deleteDto) {
//        List<AreaProductDetails> areaProductDetails  = areaProductDetailsMapper.listByIds(deleteRentHouseRequestInfoDto.getIds());
//        for (AreaProductDetails a : areaProductDetails){
//            a.setTargetType("q");
//            a.setAreaLevel(3);
//        }
//        areaProductDetailsMapper.updates(areaProductDetails);
        return Result.succeed();
    }
}
