package course.linkflower.link.oneframework.car.service.Impl;

import course.linkflower.link.oneframework.car.dao.AdvantageMapper;
import course.linkflower.link.oneframework.car.dto.advantage.AddDto;
import course.linkflower.link.oneframework.car.dto.advantage.SearchDto;
import course.linkflower.link.oneframework.car.dto.advantage.UpdateDto;
import course.linkflower.link.oneframework.car.service.AdvantageService;
import course.linkflower.link.oneframework.car.vo.advantage.AdvantageVo;
import course.linkflower.link.oneframework.common.constant.BaseErrorContst;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.model.Advantage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdvantageServiceImpl implements AdvantageService {
    @Autowired
    private AdvantageMapper advantageMapper;

    @Override
    public Result<AdvantageVo> add(AddDto addDto) {
        if (advantageMapper.countConfigId(addDto.getConfigId())!=0){
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,
                    String.format(BaseErrorContst.BaseMsgTimeParamsDuplicateError,"ConfigId"));
        }
        Advantage advantage = addDto.toAdvantage();
        advantageMapper.add(advantage);
        return Result.succeed(new AdvantageVo().loadFrom(advantage));
    }

    @Override
    public Result<AdvantageVo> getById(IdDto idDto) {
        Advantage advantage = advantageMapper.getById(Long.parseLong(idDto.getId()));
        if (advantage ==null){
            return Result.of(null,BaseErrorContst.BaseErrorNotExistError,
                    String.format(BaseErrorContst.BaseMsgNotExistError,"advantage"));
        }
        return Result.succeed(new AdvantageVo().loadFrom(advantage));
    }

    @Override
    public Result<AdvantageVo> update(UpdateDto updateDto) {
        if (advantageMapper.countConfigIdDiffId(updateDto.getConfigId(),Long.parseLong(updateDto.getId()))!=0){
            return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,
                    String.format(BaseErrorContst.BaseMsgTimeParamsDuplicateError,"configKey"));
        }
        Advantage advantage =updateDto.toCarAdvantage();
        return Result.succeed(new AdvantageVo().loadFrom(advantage));
    }

    @Override
    public PageResult<AdvantageVo> search(SearchDto searchDto) {
        List<AdvantageVo> advantageVos = advantageMapper.search(searchDto);
        PageResult<AdvantageVo> pageResult=new PageResult<>();
        pageResult.setData(advantageVos);
        pageResult.setTotal(advantageMapper.countAll(searchDto));
        pageResult.setPage(searchDto.getPage());
        pageResult.setPageSize(searchDto.getPageSize());
        return pageResult;
    }

    @Override
    public Result delete(IdDto idDto) {
        if (idDto.getIds() != null && idDto.getIds().length > 0) {
            List<Long> ids=new ArrayList<>();
            for (String id: idDto.getIds()){
                ids.add(Long.valueOf(id));
            }
            advantageMapper.deleteByIds(ids);
        }else {
            advantageMapper.deleteById(Long.parseLong(idDto.getId()));
        }
        return Result.succeed();
    }
}
