package course.linkflower.link.oneframework.car.service.Impl;

import course.linkflower.link.oneframework.car.dao.PatternPhotoMapper;
import course.linkflower.link.oneframework.car.dto.patternphoto.AddDto;
import course.linkflower.link.oneframework.car.dto.patternphoto.SearchDto;
import course.linkflower.link.oneframework.car.dto.patternphoto.UpdateDto;
import course.linkflower.link.oneframework.car.service.PatternPhotoService;
import course.linkflower.link.oneframework.car.vo.patternphoto.PatternPhotoVo;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.model.PatternPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatternPhotoServiceImpl implements PatternPhotoService {
    @Autowired
    private PatternPhotoMapper patternPhotoMapper;
    @Override
    public Result<PatternPhotoVo> add(AddDto addDto) {
        if (addDto.getOrdering()==null) {
            Integer ordering= patternPhotoMapper.lastOrdering(Long.parseLong(addDto.getPatternId()));
            if (ordering==null){
                    ordering=0;
            }
            addDto.setOrdering(ordering+1);
        }
        PatternPhoto patternPhoto = addDto.toPatternPhoto();
        patternPhotoMapper.add(patternPhoto);
        return Result.succeed(new PatternPhotoVo().loadFrom(patternPhoto));

    }

    @Override
    public Result<PatternPhotoVo> update(UpdateDto updateDto) {
        if (updateDto.getOrdering()==null) {

        }
        PatternPhoto patternPhoto = updateDto.toPatternPhoto();
        patternPhotoMapper.update(patternPhoto);
        return Result.succeed(new PatternPhotoVo().loadFrom(patternPhotoMapper.getById(patternPhoto.getId())));
    }

    @Override
    public Result delete(IdDto idDto) {
        if (idDto.getIds()!=null && idDto.getIds().length>0){
            List<Long> ids=new ArrayList<>();
            for (String id: idDto.getIds()){
                ids.add(Long.valueOf(id));
            }
            patternPhotoMapper.deleteByIds(ids);
        }
        patternPhotoMapper.deleteById(Long.parseLong(idDto.getId()));
        return Result.succeed();
    }

    @Override
    public Result<List<PatternPhotoVo>> listByPatternId(IdDto idDto) {
        return Result.succeed(PatternPhotoVo.loadFromList(patternPhotoMapper.listByPatternId(Long.parseLong(idDto.getId()))));
    }

    @Override
    public PageResult<PatternPhotoVo> search(SearchDto searchDto) {
        List<PatternPhotoVo> patternPhotoVos = patternPhotoMapper.search(searchDto);
        PageResult<PatternPhotoVo> pageResult=new PageResult<>();
        pageResult.setData(patternPhotoVos);
        pageResult.setTotal(patternPhotoMapper.countAll(searchDto));
        pageResult.setPageSize(searchDto.getPageSize());
        pageResult.setPage(searchDto.getPage());
        return pageResult;
    }
}
