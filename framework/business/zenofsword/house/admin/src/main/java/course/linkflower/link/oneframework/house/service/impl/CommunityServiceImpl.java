package course.linkflower.link.oneframework.house.service.impl;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dao.CommunityInfoMapper;
import course.linkflower.link.oneframework.house.dto.communityInfo.AddDto;
import course.linkflower.link.oneframework.house.dto.communityInfo.DeleteDto;
import course.linkflower.link.oneframework.house.dto.communityInfo.SearchDto;
import course.linkflower.link.oneframework.house.dto.communityInfo.UpdateDto;
import course.linkflower.link.oneframework.house.model.CommunityInfo;
import course.linkflower.link.oneframework.house.service.CommunityService;
import course.linkflower.link.oneframework.house.vo.communityinfo.CommunityInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityServiceImpl implements CommunityService {
    @Autowired
    CommunityInfoMapper communityInfoMapper;

    @Override
    public Result<CommunityInfoVo> add(AddDto addDto) {
        CommunityInfo communityInfo = addDto.toModel();
        communityInfoMapper.save(communityInfo);
        return Result.succeed(new CommunityInfoVo().loadFrom(communityInfo));
    }

    @Override
    public Result delete(DeleteDto deleteDto) {
        communityInfoMapper.delete(Long.parseLong(deleteDto.getId()));
        return Result.succeed();
    }

    @Override
    public Result<CommunityInfoVo> update(UpdateDto updateDto) {
        CommunityInfo communityInfo = updateDto.toModel();
        communityInfoMapper.update(communityInfo);
        return Result.succeed(new CommunityInfoVo().loadFrom(communityInfo));
    }

    @Override
    public Result<CommunityInfoVo> getById(SearchDto searchDto) {
        return Result.succeed(new CommunityInfoVo().loadFrom(communityInfoMapper.getById(Long.parseLong(searchDto.getId()))));
    }
}
