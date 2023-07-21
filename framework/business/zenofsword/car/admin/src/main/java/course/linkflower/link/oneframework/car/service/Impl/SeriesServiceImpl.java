package course.linkflower.link.oneframework.car.service.Impl;

import course.linkflower.link.oneframework.car.dao.CarConfigMapper;
import course.linkflower.link.oneframework.car.dao.SeriesMapper;
import course.linkflower.link.oneframework.car.dto.series.AddDto;
import course.linkflower.link.oneframework.car.dto.series.SearchDto;
import course.linkflower.link.oneframework.car.dto.series.UpdateDto;
import course.linkflower.link.oneframework.car.service.SeriesService;
import course.linkflower.link.oneframework.car.vo.series.SeriesVo;
import course.linkflower.link.oneframework.common.constant.BaseErrorContst;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.model.CarConfig;
import course.linkflower.link.oneframework.model.Series;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SeriesServiceImpl implements SeriesService {
    @Autowired
    private SeriesMapper seriesMapper;
    @Autowired
    private CarConfigMapper carConfigMapper;
    @Override
    public Result<SeriesVo> add(AddDto addDto) {
        if (seriesMapper.countName(addDto.getName())!=0){
            return Result.of(null,BaseErrorContst.BaseErrorTimeParamDuplicateError,
                    String.format(BaseErrorContst.BaseMsgTimeParamsDuplicateError,"name"));
        }
        if (StringUtils.isEmpty(addDto.getOrdering())) {
            Integer ordering = seriesMapper.lastCount(Long.parseLong(addDto.getBrandId()));
            if (ordering == null) {
                ordering = 0;
            }
            addDto.setOrdering(String.valueOf(ordering+1));
        }
        Series series = addDto.toCarInfor();
        seriesMapper.add(series);
        carConfigMapper.saves(addDto.toCarConfigs(series.getId()), CarConfig.TypeSeries, series.getId());
        return Result.succeed(new SeriesVo().loadFrom(series));
    }

    @Override
    public Result delete(IdDto idDto) {
        if (idDto.getIds()!=null && idDto.getIds().length>0){
            List<Long> ids=new ArrayList<>();
            for (String id: idDto.getIds()){
                ids.add(Long.valueOf(id));
            }
        }else {
            seriesMapper.deleteById(Long.parseLong(idDto.getId()));
        }
        return Result.succeed();
    }

    @Override
    public Result<SeriesVo> update(UpdateDto updateDto) {
            if (seriesMapper.countNameDiffId(updateDto.getName(), Long.parseLong(updateDto.getId())) != 0) {
                return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,
                        String.format(BaseErrorContst.BaseMsgTimeParamsDuplicateError, "name"));
            }
        Series series = updateDto.toSeries();
        seriesMapper.update(series);
        carConfigMapper.updates(updateDto.toCarConfigs(),CarConfig.TypeSeries,series.getId());
        return Result.succeed(new SeriesVo().loadFrom(seriesMapper.getById(series.getId())));
    }

    @Override
    public Result<SeriesVo> getById(IdDto idDto) {
        Series series = seriesMapper.getById(Long.parseLong(idDto.getId()));
        if (series ==null){
            return Result.of(null, BaseErrorContst.BaseErrorNotExistError,
                    String.format(BaseErrorContst.BaseMsgNotExistError,"series"));
        }
        return Result.succeed(new SeriesVo().loadFrom(series));
    }

    @Override
    public PageResult<SeriesVo> search(SearchDto searchDto) {
        List<SeriesVo> seriesVos = seriesMapper.search(searchDto);
        PageResult pageResult=new PageResult<>();
        pageResult.setData(seriesVos);
        pageResult.setCode(0);
        pageResult.setPage(searchDto.getPage());
        pageResult.setPageSize(searchDto.getPageStart());
        pageResult.setTotal(seriesMapper.countAll(searchDto));
        return pageResult;
    }
}
