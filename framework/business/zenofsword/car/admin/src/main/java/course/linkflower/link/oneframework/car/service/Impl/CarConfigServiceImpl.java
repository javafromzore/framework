package course.linkflower.link.oneframework.car.service.Impl;

import course.linkflower.link.oneframework.car.mapper.CarConfigModelMapper;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.car.dao.CarConfigMapper;
import course.linkflower.link.oneframework.car.dto.carconfig.DeleteByTargetDto;
import course.linkflower.link.oneframework.car.dto.carconfig.SearchDto;
import course.linkflower.link.oneframework.car.dto.carconfig.UpdateDto;
import course.linkflower.link.oneframework.model.CarConfig;
import course.linkflower.link.oneframework.car.service.CarConfigService;
import course.linkflower.link.oneframework.car.vo.carconfig.CarConfigVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarConfigServiceImpl implements CarConfigService {
    @Autowired
    private CarConfigModelMapper carConfigModelMapper;
    @Autowired
    private CarConfigMapper carConfigMapper;

    @Override
    public Result delete(IdDto idDto) {
        if (idDto.getIds()!=null&&idDto.getIds().length>0){
            List<Long> ids=new ArrayList<>();
            for (String id: idDto.getIds()){
                ids.add(Long.parseLong(id));
            }
            carConfigMapper.deleteByIds(ids);
        }else {
            carConfigMapper.deleteById(Long.parseLong(idDto.getId()));
        }
        return Result.succeed();
    }

    @Override
    public Result<CarConfigVo> update(UpdateDto updateDto) {
        CarConfig carConfig =new CarConfig();
        carConfigMapper.update(carConfig);
        return Result.succeed(new CarConfigVo().loadFrom(carConfigMapper.getById(carConfig.getId())));
    }

    @Override
    public void deleteByTarget(DeleteByTargetDto deleteByTargetDto) {
        ThreadLocal<String> stringThreadLocal=new ThreadLocal<>();
        carConfigMapper.deleteByTarget(carConfigModelMapper.locatesToCarConfigs(deleteByTargetDto.getLocateDtos()));
    }

    @Override
    public PageResult<CarConfigVo> search(SearchDto searchDto) {
        List<CarConfigVo> carConfigVos = carConfigMapper.search(searchDto);
        PageResult<CarConfigVo> pageResult=new PageResult<>(carConfigMapper.countAll(searchDto),searchDto.getPage()
                ,searchDto.getPageSize(),0, carConfigVos);
        return pageResult;
    }
}
