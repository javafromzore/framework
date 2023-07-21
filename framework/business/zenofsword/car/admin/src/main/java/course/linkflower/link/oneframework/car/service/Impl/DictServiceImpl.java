package course.linkflower.link.oneframework.car.service.Impl;

import course.linkflower.link.oneframework.car.dao.DictMapper;
import course.linkflower.link.oneframework.car.dto.dict.AddDto;
import course.linkflower.link.oneframework.car.dto.dict.SearchDto;
import course.linkflower.link.oneframework.car.dto.dict.UpdateDto;
import course.linkflower.link.oneframework.car.service.DictService;
import course.linkflower.link.oneframework.car.vo.dict.DictVo;
import course.linkflower.link.oneframework.common.constant.BaseErrorContst;
import course.linkflower.link.oneframework.common.constant.DbConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.dto.base.TypeDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.model.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private DictMapper dictMapper;
    @Override
    public Result<DictVo> add(AddDto addDto) {
        if (dictMapper.countTypeKey(addDto.getType(), addDto.getKey()) != 0) {
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,
                    String.format(BaseErrorContst.BaseMsgTimeParamsDuplicateError, "key"));
        }
        if (addDto.getOrdering()==null) {
            Integer ordering= dictMapper.lastOrdering(addDto.getType());
            if (ordering == null){
                ordering=0;
            }
            addDto.setOrdering(Integer.valueOf(ordering+1));
        }
        Dict dict = addDto.toDict(addDto);
        dictMapper.add(dict);
        return Result.succeed(new DictVo().loadFrom(dict));
    }

    @Override
    public Result delete(IdDto idDto) {
        if (idDto.getIds() != null && idDto.getIds().length > 0) {
            List<Long> ids=new ArrayList<>();
            for (String id: idDto.getIds()){
                ids.add(Long.parseLong(id));
            }
        }else {
            dictMapper.deleteById(Long.parseLong(idDto.getId()));
        }
        return Result.succeed();
    }

    @Override
    public Result<DictVo> update(UpdateDto updateDto) {
        if (dictMapper.countTypeKeyDiffId(updateDto.getType(), updateDto.getKey(), Long.parseLong(updateDto.getId())) != 0) {
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,
                    String.format(BaseErrorContst.BaseMsgTimeParamsDuplicateError, "key"));
        }
        if (updateDto.getOrdering()==null) {
            Integer ordering = dictMapper.lastOrdering(updateDto.getType());
            if (ordering == null) {
                ordering = 0;
            }
            updateDto.setOrdering(ordering + 1);
        }
        dictMapper.update(updateDto.toDict(updateDto));
        return Result.succeed(new DictVo().loadFrom(dictMapper.getById(Long.parseLong(updateDto.getId()))));
    }

    @Override
    public Result<DictVo> getById(IdDto idDto) {
        Dict dict=dictMapper.getById(Long.parseLong(idDto.getId()));
        if (dict==null){
            return Result.of(null,BaseErrorContst.BaseErrorNotExistError,
                    String.format(BaseErrorContst.BaseMsgNotExistError,"dict"));
        }
        return Result.succeed(new DictVo().loadFrom(dict));
    }

    @Override
    public PageResult<DictVo> search(SearchDto searchDto) {
        List<DictVo> dictVos= dictMapper.search(searchDto);
        PageResult<DictVo> pageResult=new PageResult<>();
        pageResult.setData(dictVos);
        pageResult.setTotal(dictMapper.countAll(searchDto));
        pageResult.setPageSize(searchDto.getPageSize());
        pageResult.setPage(searchDto.getPage());
        return pageResult;
    }

    @Override
    public Result<List<DictVo>> listByType(TypeDto typeDto) {
        return Result.succeed(DictVo.loadFromList(dictMapper.listByType(typeDto.getType(),
                DbConstant.DefaultMaxCountLimit)));
    }
}
