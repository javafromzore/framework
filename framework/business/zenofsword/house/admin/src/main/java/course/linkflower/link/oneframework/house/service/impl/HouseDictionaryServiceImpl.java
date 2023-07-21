package course.linkflower.link.oneframework.house.service.impl;
import course.linkflower.link.oneframework.common.constant.BaseErrorContst;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.consts.HouseConstant;
import course.linkflower.link.oneframework.house.dao.HouseDictionaryMapper;
import course.linkflower.link.oneframework.house.dto.base.IdDto;
import course.linkflower.link.oneframework.house.dto.housedevicetype.HousePageDto;
import course.linkflower.link.oneframework.house.dto.housedictionary.*;
import course.linkflower.link.oneframework.house.model.HouseDictionary;
import course.linkflower.link.oneframework.house.model.HousePageResult;
import course.linkflower.link.oneframework.house.service.HouseDictionaryService;
import course.linkflower.link.oneframework.house.vo.housedictionary.HouseDictionaryVo;
import course.linkflower.link.oneframework.house.vo.housedictionary.ShortHouseDictionaryVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseDictionaryServiceImpl implements HouseDictionaryService {
    @Autowired
    HouseDictionaryMapper houseDictionaryMapper;

    @Override
    public Result<List<ShortHouseDictionaryVo>> listType(ChooseDto chooseDto) {
        //用户未选择
        if (chooseDto == null){
            return Result.of(null,BaseErrorContst.BaseErrorClientNoChooseError,BaseErrorContst.BaseMsgClientNoChooseError);
        }
        List<ShortHouseDictionaryVo> shortHouseDictionaryVos =  new ArrayList<>();
        //提取/加载字典数据
        List<HouseDictionary> houseDictionaries = houseDictionaryMapper.listByType(chooseDto.getType());
        for (HouseDictionary h : houseDictionaries){
            shortHouseDictionaryVos.add(new ShortHouseDictionaryVo().loadFrom(h));
        }
        return Result.succeed(shortHouseDictionaryVos);
    }

    @Override
    public Result<HouseDictionaryVo> add(AddDto addDto) {
       HouseDictionary houseDictionary =  addDto.toModel();
       HouseDictionaryVo houseDictionaryVo = new HouseDictionaryVo();
       if (houseDictionary.getSortValue() == null) {
           houseDictionary.setSortValue(houseDictionaryMapper.lastSortValueByType(addDto.getType()) + 1);
       }
       if (StringUtils.isEmpty(houseDictionary.getKey())){
            houseDictionary.setKey(houseDictionary.getSortValue()+"");
       }
       if (houseDictionary.getKey()!=null && houseDictionaryMapper.countByTypeKey(addDto.getType(),houseDictionary.getKey())!=0){
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,BaseErrorContst.BaseMsgTimeParamsDuplicateError);
       }
       houseDictionaryMapper.save(houseDictionary);
       houseDictionaryVo = houseDictionaryVo.loadFrom(houseDictionary);
       return Result.succeed(houseDictionaryVo);
    }

    @Override
    public Result delete(DeleteDto deleteDto) {
        if (!StringUtils.isEmpty(deleteDto.getId()) && deleteDto.getIds()==null) {
            houseDictionaryMapper.delete(Long.parseLong(deleteDto.getId()));
        }
        if (StringUtils.isEmpty(deleteDto.getId()) && deleteDto.getIds()!=null) {
            houseDictionaryMapper.deleteAll(HouseConstant.stringToLong(deleteDto.getIds()));
        }
        return Result.succeed();
    }

    @Override
    public Result<HouseDictionaryVo> update(UpdateDto updateDto) {
        HouseDictionary houseDictionary = updateDto.toModel();
        houseDictionary.setSortValue(houseDictionaryMapper.lastSortValueByType(updateDto.getType()) + 1);
        if (houseDictionaryMapper.countByTypeKey(updateDto.getType(), updateDto.getKey())!=0){
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,BaseErrorContst.BaseMsgTimeParamsDuplicateError);
        }
        houseDictionaryMapper.update(houseDictionary);
        return Result.succeed(new HouseDictionaryVo().loadFrom(houseDictionary));
    }


    @Override
    public HousePageResult<HouseDictionaryVo> search(HousePageDto housePageDto) {
        List<HouseDictionaryVo> houseDictionaryVoList = houseDictionaryMapper.search(housePageDto);
        HousePageResult<HouseDictionaryVo> housePageResult =new HousePageResult<>();
        housePageResult.setData(houseDictionaryVoList);
        housePageResult.setCount(houseDictionaryMapper.countAll());
        housePageResult.setPage(housePageDto.getPage());
        housePageResult.setPageSize(housePageDto.getPageSize());
        return housePageResult;
    }

    @Override
    public Result<HouseDictionaryVo> getById(IdDto idDto) {
        HouseDictionary ret = houseDictionaryMapper.getById(Long.parseLong(idDto.getId()));
        if (ret == null) {
            return Result.of(null, -1, "字典不存在");
        }
        return Result.succeed(new HouseDictionaryVo().loadFrom(ret) );
    }
}
