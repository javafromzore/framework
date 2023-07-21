package course.linkflower.link.oneframework.house.service.impl;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dao.CommissionMapper;
import course.linkflower.link.oneframework.house.dto.commission.AddDto;
import course.linkflower.link.oneframework.house.dto.commission.DeleteDto;
import course.linkflower.link.oneframework.house.dto.commission.SearchDto;
import course.linkflower.link.oneframework.house.dto.commission.UpdateDto;
import course.linkflower.link.oneframework.house.model.Commission;
import course.linkflower.link.oneframework.house.service.CommissionService;
import course.linkflower.link.oneframework.house.vo.commission.CommissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommissionServiceImpl implements CommissionService {
    @Autowired
    CommissionMapper commissionMapper;

    @Override
    public Result<CommissionVo> add(AddDto addDto) {
        Commission commission = addDto.toModel();
        commissionMapper.save(commission);
        return Result.succeed(new CommissionVo().loadFrom(commission));
    }

    @Override
    public Result delete(DeleteDto deleteDto) {
        commissionMapper.delete(Long.parseLong(deleteDto.getId()));
        return Result.succeed();
    }

    @Override
    public Result<CommissionVo> update(UpdateDto updateDto) {
        Commission commission = updateDto.toModel();
        commissionMapper.update(commission);
        return Result.succeed(new CommissionVo().loadFrom(commission));
    }

    @Override
    public Result<CommissionVo> getById(SearchDto searchDto) {
        return Result.succeed(new CommissionVo().loadFrom(commissionMapper.getById(Long.parseLong(searchDto.getId()))));
    }
}
