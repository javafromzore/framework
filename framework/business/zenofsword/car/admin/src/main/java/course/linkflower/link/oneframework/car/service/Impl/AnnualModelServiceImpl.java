package course.linkflower.link.oneframework.car.service.Impl;

import course.linkflower.link.oneframework.car.dao.AnnualModelMapper;
import course.linkflower.link.oneframework.car.dto.annualmodel.AddDto;
import course.linkflower.link.oneframework.car.dto.annualmodel.SearchDto;
import course.linkflower.link.oneframework.car.dto.annualmodel.UpdateDto;
import course.linkflower.link.oneframework.car.service.AnnualModelServiceI;
import course.linkflower.link.oneframework.car.vo.annualmodel.AnnualModelVo;
import course.linkflower.link.oneframework.common.constant.BaseErrorContst;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.model.AnnualModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnnualModelServiceImpl implements AnnualModelServiceI {
    @Autowired
    private AnnualModelMapper annualModelMapper;
    @Override
    public Result<AnnualModelVo> add(AddDto addDto) {
        if (annualModelMapper.countSeriesIdYear(Long.parseLong(addDto.getSeriesId()),addDto.getYear())!=0){
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,
                    String.format(BaseErrorContst.BaseMsgTimeParamsDuplicateError,"year"));
        }
        if (addDto.getOrdering() == null){
            Integer ordering= annualModelMapper.lastOrdering();
            if (ordering==null){
                ordering=0;
            }
            addDto.setOrdering(ordering + 1);
        }
        AnnualModel annualModel = addDto.toCarVersion();
        annualModelMapper.add(annualModel);
        return Result.succeed(new AnnualModelVo().loadFrom(annualModel));
    }

    @Override
    public Result delete(IdDto idDto) {
        if (idDto.getIds()!=null && idDto.getIds().length>0){
            List<Long> ids=new ArrayList<>();
            for (String s: idDto.getIds()){
                ids.add(Long.parseLong(s));
            }
            annualModelMapper.deleteByIds(ids);
        }else {
            annualModelMapper.deleteById(Long.parseLong(idDto.getId()));
        }
        return Result.succeed();
    }

    @Override
    public Result<AnnualModelVo> update(UpdateDto updateDto) {
        if (updateDto.getYear()==null){
            return Result.of(null,BaseErrorContst.BaseErrorTimeParamnotEnteredError,
                    String.format(BaseErrorContst.BaseMsgTimeParamnotEnteredError,"year"));
        }
        if (annualModelMapper.countSeriesIdYearDiffId(Long.parseLong(updateDto.getSeriesId()),updateDto.getYear(),
                Long.parseLong(updateDto.getId()))!=0){
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,
                    String.format(BaseErrorContst.BaseMsgTimeParamsDuplicateError,"year"));
        }
        AnnualModel annualModel =updateDto.toCarVersion();
        annualModelMapper.update(annualModel);
        return Result.succeed(new AnnualModelVo().loadFrom(annualModelMapper.getById(annualModel.getId())));
    }

    @Override
    public PageResult<AnnualModelVo> search(SearchDto searchDto) {
        List<AnnualModelVo> annualModelVos = annualModelMapper.search(searchDto);
        PageResult<AnnualModelVo> pageResult=new PageResult<>(annualModelMapper.countAll(searchDto),
                searchDto.getPage(), searchDto.getPageSize(),0, annualModelVos);
        return pageResult;
    }


    @Override
    public Result<AnnualModelVo> getById(IdDto idDto) {
        AnnualModel annualModel = annualModelMapper.getById(Long.parseLong(idDto.getId()));
        if (annualModel == null) {
            return Result.of(null,  BaseErrorContst.BaseErrorNotExistError,
                    String.format(BaseErrorContst.BaseMsgNotExistError,"annualModel"));
        }
        return Result.succeed(new AnnualModelVo().loadFrom(annualModel));
    }
}
