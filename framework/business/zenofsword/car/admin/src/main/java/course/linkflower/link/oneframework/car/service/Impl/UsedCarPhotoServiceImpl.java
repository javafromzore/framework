package course.linkflower.link.oneframework.car.service.Impl;

import course.linkflower.link.oneframework.common.constant.BaseErrorContst;
import course.linkflower.link.oneframework.common.constant.DbConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.dao.UsedCarPhotoMapper;
import course.linkflower.link.oneframework.car.dto.usedcarphoto.SearchDto;
import course.linkflower.link.oneframework.car.dto.usedcarphoto.UpdateDto;
import course.linkflower.link.oneframework.car.dto.usedcarphoto.AddDto;
import course.linkflower.link.oneframework.model.UsedCarPhoto;
import course.linkflower.link.oneframework.car.service.UsedCarPhotoService;
import course.linkflower.link.oneframework.car.vo.usedcarphoto.UsedCarPhotoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsedCarPhotoServiceImpl implements UsedCarPhotoService {
    @Autowired
    private UsedCarPhotoMapper usedCarPhotoMapper;

    @Override
    public Result<UsedCarPhotoVo> add(AddDto addDto) {
        if (addDto.getOrdering()==null){
            Integer ordering =usedCarPhotoMapper.lastOrdering(Long.parseLong(addDto.getUsedCarId()));
            if (ordering==null){
                ordering=0;
            }
            addDto.setOrdering(ordering+1);
        }
        UsedCarPhoto usedCarPhoto= addDto.toModel(addDto);
        usedCarPhotoMapper.add(usedCarPhoto);
        return Result.succeed(new UsedCarPhotoVo().loadFrom(usedCarPhoto));
    }

    @Override
    public Result<UsedCarPhotoVo> update(UpdateDto updateDto) {
        UsedCarPhoto usedCarPhoto= updateDto.toModel(updateDto);
        usedCarPhotoMapper.update(usedCarPhoto);
        return Result.succeed(new UsedCarPhotoVo().loadFrom(usedCarPhotoMapper.getById(usedCarPhoto.getId())));
    }

    @Override
    public Result delete(IdDto idDto) {
        if (idDto.getIds()!=null && idDto.getIds().length>0){
            List<Long> ids=new ArrayList<>();
            for (String id: idDto.getIds()){
                ids.add(Long.valueOf(id));
            }
            usedCarPhotoMapper.deleteByIds(ids);
        }else {
                usedCarPhotoMapper.deleteById(Long.parseLong(idDto.getId()));
        }
        return Result.succeed();
    }

    @Override
    public Result<List<UsedCarPhotoVo>> listByUsedCarId(IdDto idDto) {
        return Result.succeed(UsedCarPhotoVo.loadFromList(usedCarPhotoMapper.listByUsedCarId(Long.parseLong(idDto.getId()),
                DbConstant.DefaultMaxCountLimit)));
    }

    @Override
    public Result<UsedCarPhotoVo> getById(IdDto idDto) {
        UsedCarPhoto usedCarPhoto=usedCarPhotoMapper.getById(Long.parseLong(idDto.getId()));
        if (usedCarPhoto==null){
            return Result.of(null, BaseErrorContst.BaseErrorNotExistError,
                    String.format(BaseErrorContst.BaseMsgNotExistError,"usedCarPhoto"));
        }
        return Result.succeed(new UsedCarPhotoVo().loadFrom(usedCarPhoto));
    }

    @Override
    public PageResult<UsedCarPhotoVo> search(SearchDto searchDto) {
        List<UsedCarPhotoVo> usedCarPhotoVos =usedCarPhotoMapper.search(searchDto); 
        PageResult<UsedCarPhotoVo> pageResult=new PageResult<>();
        pageResult.setData(usedCarPhotoVos);
        pageResult.setTotal(usedCarPhotoMapper.countAll(searchDto));
        pageResult.setPageSize(searchDto.getPageSize());
        pageResult.setPage(searchDto.getPage());
        return pageResult;
    }
}
