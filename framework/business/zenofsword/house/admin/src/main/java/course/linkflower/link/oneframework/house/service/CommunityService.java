package course.linkflower.link.oneframework.house.service;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.communityInfo.AddDto;
import course.linkflower.link.oneframework.house.dto.communityInfo.DeleteDto;
import course.linkflower.link.oneframework.house.dto.communityInfo.SearchDto;
import course.linkflower.link.oneframework.house.dto.communityInfo.UpdateDto;
import course.linkflower.link.oneframework.house.vo.communityinfo.CommunityInfoVo;

public interface CommunityService {
    Result<CommunityInfoVo> add(AddDto addDto);
    Result delete(DeleteDto deleteDto);
    Result<CommunityInfoVo> update(UpdateDto updateDto);
    Result<CommunityInfoVo> getById(SearchDto searchDto);
}
