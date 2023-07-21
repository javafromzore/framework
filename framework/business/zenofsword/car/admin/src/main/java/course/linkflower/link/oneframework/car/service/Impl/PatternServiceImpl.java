package course.linkflower.link.oneframework.car.service.Impl;

import course.linkflower.link.oneframework.car.dao.CarConfigMapper;
import course.linkflower.link.oneframework.car.dao.ConfigMapper;
import course.linkflower.link.oneframework.car.dao.PatternMapper;
import course.linkflower.link.oneframework.car.dto.carconfig.RelevanceDto;
import course.linkflower.link.oneframework.car.dto.pattern.AddDto;
import course.linkflower.link.oneframework.car.dto.pattern.SearchDto;
import course.linkflower.link.oneframework.car.dto.pattern.UpdateDto;
import course.linkflower.link.oneframework.car.mapper.CarConfigModelMapper;
import course.linkflower.link.oneframework.car.mapper.PatternModelMapper;
import course.linkflower.link.oneframework.car.service.PatternService;
import course.linkflower.link.oneframework.car.vo.config.ConfigDetailVo;
import course.linkflower.link.oneframework.car.vo.pattern.PatternDetailVo;
import course.linkflower.link.oneframework.car.vo.pattern.PatternVo;
import course.linkflower.link.oneframework.common.constant.BaseErrorEnum;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.exception.BusinessException;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.model.CarConfig;
import course.linkflower.link.oneframework.model.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatternServiceImpl implements PatternService {
    @Autowired
    private PatternModelMapper patternModelMapper;
    @Autowired
    private CarConfigModelMapper carConfigModelMapper;
    @Autowired
    private PatternMapper patternMapper;
    @Autowired
    private ConfigMapper configMapper;
    @Autowired
    private CarConfigMapper carConfigMapper;
    @Override
    public PatternVo add(AddDto addDto) {
        if (patternMapper.countNameAnnualId(addDto.getName(),Long.parseLong(addDto.getAnnualId()))!=0){
            throw new BusinessException(BaseErrorEnum.TimeParamDuplicate.getCode(),
                    String.format(BaseErrorEnum.TimeParamDuplicate.getMessage(),"name"));
        }
        if (addDto.getOrdering()==null){
            Integer ordering=patternMapper.lastCount();
            if (ordering==null){
                ordering=0;
            }
            addDto.setOrdering(ordering+1);
        }
        Pattern pattern =patternModelMapper.addToPattern(addDto);
        patternMapper.add(pattern);
        if (addDto.getOtherUseDtos()!=null && addDto.getOtherUseDtos().size()>0) {
            carConfigMapper.saves(carConfigModelMapper.otherUseToCarConfig(addDto.getOtherUseDtos()),
                    CarConfig.TypePattern, pattern.getId());
        }
        return  patternModelMapper.patternToVo(pattern);
    }

    @Override
    public void delete(IdDto idDto) {
        if (idDto.getIds() != null && idDto.getIds().length > 0) {
            List<Long> ids=new ArrayList<>();
            for (String id: idDto.getIds()){
                ids.add(Long.valueOf(id));
            }
            patternMapper.deletByIds(ids);
        }else {
            patternMapper.deleteById(Long.parseLong(idDto.getId()));
        }
    }

    @Override
    public PatternVo update(UpdateDto updateDto) {
        if (patternMapper.countNameAnnualIdDiffId(updateDto.getName(),Long.parseLong(updateDto.getAnnualId()),
                Long.parseLong(updateDto.getId()))!=0){
            throw new BusinessException(BaseErrorEnum.TimeParamDuplicate.getCode(),
                    String.format(BaseErrorEnum.TimeParamDuplicate.getMessage(),"name"));
        }
            Pattern pattern = patternModelMapper.updateToPattern(updateDto);
            patternMapper.update(pattern);
            if (updateDto.getOtherUseDtos()!=null && updateDto.getOtherUseDtos().size()>0) {
                carConfigMapper.updates(carConfigModelMapper.otherUseToCarConfig(updateDto.getOtherUseDtos()),
                        CarConfig.TypePattern, pattern.getId());
            }
            return  patternModelMapper.patternToVo(patternMapper.getById(pattern.getId()));
    }

    @Override
    public PatternVo getById(IdDto idDto) {
        Pattern pattern = patternMapper.getById(Long.parseLong(idDto.getId()));
        if (pattern == null) {
            throw new BusinessException(BaseErrorEnum.NotExist.getCode(),
                    String.format(BaseErrorEnum.NotExist.getMessage(),"pattern"));
        }
        return patternModelMapper.patternToVo(pattern);
    }

    @Override
    public PageResult<PatternVo> search(SearchDto searchDto) {
        List<PatternVo> patternVos = patternMapper.search(searchDto);
        PageResult<PatternVo> pageResult=new PageResult<>();
        pageResult.setData(patternVos);
        pageResult.setTotal(patternMapper.countAll(searchDto));
        pageResult.setPageSize(searchDto.getPageSize());
        pageResult.setPage(searchDto.getPage());
        return pageResult;
    }

    @Override
    public PatternDetailVo detail(IdDto idDto) {
        Pattern pattern=patternMapper.getById(Long.parseLong(idDto.getId()));
        List<RelevanceDto> relevanceDtos=new ArrayList<>();
        //放置series信息
        RelevanceDto relevanceSeries=new RelevanceDto();
        relevanceSeries.setType(CarConfig.TypeSeries);
        relevanceSeries.setTargetId(pattern.getSeriesId());
        relevanceDtos.add(relevanceSeries);

        //放置annualModel信息
        RelevanceDto relevanceAnnual=new RelevanceDto();
        relevanceAnnual.setType(CarConfig.TypeAnnualModel);
        relevanceAnnual.setTargetId(pattern.getAnnualId());
        relevanceDtos.add(relevanceAnnual);

        //放置pattern信息
        RelevanceDto relevancePattern=new RelevanceDto();
        relevancePattern.setType(CarConfig.TypePattern);
        relevancePattern.setTargetId(pattern.getId());
        relevanceDtos.add(relevancePattern);

        //制作configDetailVo
        List<ConfigDetailVo> configDetailVos = configMapper.detail(relevanceDtos);
        return patternModelMapper.detail(pattern,configDetailVos);
    }
}
