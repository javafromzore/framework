package course.linkflower.link.oneframework.car.service.Impl;

import course.linkflower.link.oneframework.car.dao.ConfigMapper;
import course.linkflower.link.oneframework.car.dto.config.AddDto;
import course.linkflower.link.oneframework.car.dto.config.SearchDto;
import course.linkflower.link.oneframework.car.dto.config.UpdateDto;
import course.linkflower.link.oneframework.car.service.ConfigService;
import course.linkflower.link.oneframework.car.vo.config.ConfigVo;
import course.linkflower.link.oneframework.common.constant.BaseErrorContst;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.model.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private ConfigMapper configMapper;
    @Override
    public Result<ConfigVo> add(AddDto addDto) {
        if (configMapper.countName(addDto.getName())!=0){
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,
                    String.format(BaseErrorContst.BaseMsgTimeParamsDuplicateError,"name"));
        }
        if (addDto.getOrdering()!=null){
            Integer ordering= configMapper.lastOrdering();
            if (ordering==null){
                ordering=0;
            }
            addDto.setOrdering(ordering+1);
        }
        Config config = addDto.toCarAttrib();
        configMapper.add(config);
        return Result.succeed(new ConfigVo().loadFrom(config));
    }

    @Override
    public Result delete(IdDto idDto) {
        if (idDto.getIds()!=null && idDto.getIds().length>0){
            List<Long> ids=new ArrayList<>();
            for (String id: idDto.getIds()){
                ids.add(Long.valueOf(id));
            }
            configMapper.deleteByIds(ids);
        }else {
            configMapper.deleteById(Long.parseLong(idDto.getId()));
        }
        return Result.succeed();
    }

    @Override
    public Result<ConfigVo> update(UpdateDto updateDto) {
        if (configMapper.countNameDiffId(updateDto.getName(),Long.valueOf(updateDto.getId()))!=0){
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,
                    String.format(BaseErrorContst.BaseMsgTimeParamsDuplicateError,"name"));
        }
        Config config =updateDto.toCarAttrib();
        configMapper.update(config);
        return Result.succeed(new ConfigVo().loadFrom(configMapper.getById(config.getId())));
    }

    @Override
    public PageResult<ConfigVo> search(SearchDto searchDto) {
        List<ConfigVo> configVos = configMapper.search(searchDto);
        PageResult<ConfigVo> pageResult=new PageResult<>();
        pageResult.setPageSize(searchDto.getPageSize());
        pageResult.setTotal(configMapper.countAll(searchDto));
        return pageResult;
    }


    @Override
    public Result<ConfigVo> getById(IdDto idDto) {
        Config config = configMapper.getById(Long.parseLong(idDto.getId()));
        if (config == null) {
            return Result.of(null,  BaseErrorContst.BaseErrorNotExistError,
                    String.format(BaseErrorContst.BaseMsgNotExistError,"config"));
        }
        return Result.succeed(new ConfigVo().loadFrom(config));
    }
}
