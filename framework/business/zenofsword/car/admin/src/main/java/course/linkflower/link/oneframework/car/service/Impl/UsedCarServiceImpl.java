package course.linkflower.link.oneframework.car.service.Impl;

import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.dao.UsedCarMapper;
import course.linkflower.link.oneframework.car.dto.usedcar.SearchDto;
import course.linkflower.link.oneframework.car.dto.usedcar.UsedCarDto;
import course.linkflower.link.oneframework.car.dto.usedcar.AddDto;
import course.linkflower.link.oneframework.model.UsedCar;
import course.linkflower.link.oneframework.car.service.UsedCarService;
import course.linkflower.link.oneframework.car.vo.usedcar.UsedCarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UsedCarServiceImpl implements UsedCarService {
    @Autowired
    private UsedCarMapper usedCarMapper;

    @Override
    public Result<UsedCarVo> add(AddDto addDto) {
        UsedCar usedCar= addDto.toModel();
        usedCarMapper.add(usedCar);
        return Result.succeed(new UsedCarVo().loadFrom(usedCar));
    }

    @Override
    public Result delete(IdDto idDto) {
        if (idDto.getIds()!=null && idDto.getIds().length>0){
            List<Long> ids=new ArrayList<>();
            for (String s: idDto.getIds()){
                ids.add(Long.parseLong(s));
            }
            usedCarMapper.deleteByIds(ids);
        }else {
            usedCarMapper.deleteById(Long.parseLong(idDto.getId()));
        }
        return Result.succeed();
    }

    @Override
    public Result<UsedCarVo> update(UsedCarDto usedCarDto) {
        UsedCar usedCar=usedCarDto.toModel();
        usedCarMapper.update(usedCar);
        return Result.succeed(usedCarMapper.getUsedCarById(Long.parseLong(usedCarDto.getId())));
    }

    @Override
    public Result<UsedCarVo> getById(IdDto idDto) {
        return Result.succeed(usedCarMapper.getUsedCarById(Long.parseLong(idDto.getId())));
    }

    @Override
    public PageResult<UsedCarVo> search(SearchDto searchDto) {
        List<UsedCarVo> list=usedCarMapper.loadPageByPostDateStatus(searchDto.getPageStart(),searchDto.getPageSize(),
                searchDto.getPostDate(),searchDto.getStatus());
        PageResult<UsedCarVo> pageResult=new PageResult<>();
        pageResult.setData(list);
        pageResult.setTotal(usedCarMapper.countAll());
        pageResult.setPageSize(searchDto.getPageSize());
        pageResult.setPage(searchDto.getPage());
        return pageResult;
    }
}
