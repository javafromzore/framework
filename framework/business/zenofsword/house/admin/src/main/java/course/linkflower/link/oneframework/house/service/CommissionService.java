package course.linkflower.link.oneframework.house.service;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.commission.AddDto;
import course.linkflower.link.oneframework.house.dto.commission.DeleteDto;
import course.linkflower.link.oneframework.house.dto.commission.SearchDto;
import course.linkflower.link.oneframework.house.dto.commission.UpdateDto;
import course.linkflower.link.oneframework.house.vo.commission.CommissionVo;

public interface CommissionService {
    Result<CommissionVo> add(AddDto addDto);
    Result delete(DeleteDto deleteDto);
    Result<CommissionVo> update(UpdateDto updateDto);
    Result<CommissionVo> getById(SearchDto searchDto);
}
