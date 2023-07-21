package course.linkflower.link.oneframework.car.service.Impl;

import course.linkflower.link.oneframework.car.dao.CarDictMapper;
import course.linkflower.link.oneframework.car.dto.cardict.AddDto;
import course.linkflower.link.oneframework.car.dto.cardict.SearchDto;
import course.linkflower.link.oneframework.car.dto.cardict.UpdateDto;
import course.linkflower.link.oneframework.car.service.CarDictService;
import course.linkflower.link.oneframework.car.vo.cardict.CarDictInfoVo;
import course.linkflower.link.oneframework.car.vo.cardict.CarDictVo;
import course.linkflower.link.oneframework.car.vo.cardict.SearchVo;
import course.linkflower.link.oneframework.common.constant.BaseErrorContst;
import course.linkflower.link.oneframework.common.constant.DbConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.dto.base.TypeDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.model.CarDict;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarDictServiceImpl implements CarDictService {
    @Autowired
    private CarDictMapper carDictMapper;
    @Override
    public Result<CarDictVo> add(AddDto addDto) {
        if (carDictMapper.countTypeKey(addDto.getType(), addDto.getKey()) != 0) {
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,
                    String.format(BaseErrorContst.BaseMsgTimeParamsDuplicateError, "key"));
        }
        if (addDto.getOrdering()==null) {
            Integer ordering= carDictMapper.lastOrdering(addDto.getType());
            if (ordering == null){
                ordering=0;
            }
                addDto.setOrdering(ordering+1);
        }
        if (StringUtils.isEmpty(addDto.getKey())){
            addDto.setKey(String.valueOf(addDto.getOrdering()));
        }
        CarDict carDict = addDto.toCarDict(addDto);
        carDictMapper.add(carDict);
        return Result.succeed(new CarDictVo().loadFrom(carDict));
    }

    @Override
    public Result delete(IdDto idDto) {
        if (idDto.getIds()!=null&&idDto.getIds().length>0){
            List<Long> ids=new ArrayList<>();
            for (String s: idDto.getIds()){
                ids.add(Long.valueOf(s));
            }
            carDictMapper.deleteByIds(ids);
        }else {
            carDictMapper.deleteById(Long.parseLong(idDto.getId()));
        }
        return Result.succeed();
    }

    @Override
    public Result<CarDictVo> update(UpdateDto updateDto) {
        if (carDictMapper.countTypeKeyDiffId(updateDto.getKey(), updateDto.getValue(), Long.parseLong(updateDto.getId())) != 0) {
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,
                    String.format(BaseErrorContst.BaseMsgTimeParamsDuplicateError, "key"));
        }
        carDictMapper.update(updateDto.toCarDict(updateDto));
        return Result.succeed(new CarDictVo().loadFrom(carDictMapper.getById(Long.parseLong(updateDto.getId()))));
    }

    @Override
    public Result<List<CarDictInfoVo>> listInfosByType(TypeDto typeDto) {
        return Result.succeed(carDictMapper.listInfoByType(typeDto.getType(), DbConstant.SearchShowCountLimit));
    }

    @Override
    public Result<CarDictVo> getById(IdDto idDto) {
        CarDict dict= carDictMapper.getById(Long.parseLong(idDto.getId()));
        if (dict == null) {
            return Result.of(null,BaseErrorContst.BaseErrorNotExistError,
                    String.format(BaseErrorContst.BaseMsgNotExistError,"carDict"));
        }
        return Result.succeed(new CarDictVo().loadFrom(dict));
    }

    @Override
    public PageResult<SearchVo> search(SearchDto searchDto) {
        List<SearchVo> searchVos= carDictMapper.search(searchDto);
        PageResult pageResult=new PageResult<>();
        pageResult.setData(searchVos);
        pageResult.setTotal(carDictMapper.countAll(searchDto));
        pageResult.setPageSize(searchDto.getPageSize());
        pageResult.setPage(searchDto.getPage());
        return pageResult;
    }
}
