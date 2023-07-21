package course.linkflower.link.oneframework.car.service.Impl;

import course.linkflower.link.oneframework.car.dao.ModificationMapper;
import course.linkflower.link.oneframework.car.service.ModificationService;
import course.linkflower.link.oneframework.car.vo.modification.ModificationVo;
import course.linkflower.link.oneframework.common.constant.BaseErrorContst;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.dto.modification.AddDto;
import course.linkflower.link.oneframework.car.dto.modification.SearchDto;
import course.linkflower.link.oneframework.car.dto.modification.UpdateDto;
import course.linkflower.link.oneframework.model.Modification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ModificationServiceImpl implements ModificationService {
    @Autowired
    private ModificationMapper modificationMapper;
    @Override
    public Result<ModificationVo> add(AddDto addDto) {
        Modification modification= addDto.toModification();
        modificationMapper.add(modification);
        return Result.succeed(new ModificationVo().loadFrom(modification));
    }

    @Override
    public Result<ModificationVo> getById(IdDto idDto) {
        Modification modification= modificationMapper.getById(Long.parseLong(idDto.getId()));
        if (modification == null) {
            return Result.of(null,BaseErrorContst.BaseErrorNotExistError,
                    String.format(BaseErrorContst.BaseMsgNotExistError,"modification"));
        }
        return Result.succeed(new ModificationVo().loadFrom(modification));
    }

    @Override
    public PageResult<ModificationVo> search(SearchDto searchDto) {
        List<ModificationVo> modificationVos = modificationMapper.search(searchDto);
        PageResult<ModificationVo> pageResult = new PageResult<>();
        pageResult.setData(modificationVos);
        pageResult.setTotal(modificationMapper.countAll(searchDto));
        pageResult.setPageSize(searchDto.getPageSize());
        pageResult.setPage(searchDto.getPage());
        return pageResult;
    }

    @Override
    public Result<ModificationVo> update(UpdateDto updateDto) {
        Modification modification = updateDto.toModification();
        modificationMapper.update(modification);
        return Result.succeed(new ModificationVo().loadFrom(modificationMapper.getById(modification.getId())));
    }

    @Override
    public Result delete(IdDto idDto) {
        if (idDto.getIds()!=null && idDto.getIds().length>0){
            List<Long> ids=new ArrayList<>();
            for (String id: idDto.getIds()){
                ids.add(Long.valueOf(id));
            }
            modificationMapper.deleteByIds(ids);
        }
        modificationMapper.deleteById(Long.parseLong(idDto.getId()));
        return Result.succeed();
    }
}
