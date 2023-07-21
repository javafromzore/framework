package course.linkflower.link.oneframework.house.service.impl;

import course.linkflower.link.oneframework.common.constant.BaseErrorContst;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dao.AreaInfoMapper;
import course.linkflower.link.oneframework.house.dto.areainfo.*;
import course.linkflower.link.oneframework.house.model.AreaInfo;
import course.linkflower.link.oneframework.house.service.AreaInfoService;
import course.linkflower.link.oneframework.house.vo.areainfo.AreaInfoVo;
import course.linkflower.link.oneframework.house.vo.areainfo.ShortAreaInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaInfoServiceImpl implements AreaInfoService {
    @Autowired
    AreaInfoMapper areaInfoMapper;

    @Override
    public Result<AreaInfoVo> add(AddDto addDto) {
        AreaInfo areaInfo = addDto.toModel();
        areaInfoMapper.save(areaInfo);
        return Result.succeed(new AreaInfoVo().loadFrom(areaInfo));
    }

    @Override
    public Result delete(DeleteDto deleteDto) {
        areaInfoMapper.delete(Long.parseLong(deleteDto.getId()));
        return Result.succeed();
    }

    @Override
    public Result<AreaInfoVo> update(UpdateDto updateDto) {
        AreaInfo areaInfo = updateDto.toModel();
        areaInfoMapper.update(areaInfo);
        return Result.succeed(new AreaInfoVo().loadFrom(areaInfo));
    }

    @Override
    public Result<AreaInfoVo> getById(SearchDto searchDto) {
        return Result.succeed(new AreaInfoVo().loadFrom(areaInfoMapper.getById(Long.parseLong(searchDto.getId()))));
    }

    @Override
    public Result<List<ShortAreaInfoVo>> searchByAdd(SearchByKey searchByKey) {
        List<AreaInfo> areaInfos = new ArrayList<>();
        //用户未选择
        if (searchByKey.getType()==null){
            return Result.of(null, BaseErrorContst.BaseErrorClientNoChooseError,BaseErrorContst.BaseMsgClientNoChooseError);
        }
        areaInfos = areaInfoMapper.listByName(searchByKey.getSearchKey());
        return null;
    }
}
