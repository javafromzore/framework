package course.linkflower.link.oneframework.house.controller;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.communityInfo.AddDto;
import course.linkflower.link.oneframework.house.dto.communityInfo.DeleteDto;
import course.linkflower.link.oneframework.house.dto.communityInfo.SearchDto;
import course.linkflower.link.oneframework.house.dto.communityInfo.UpdateDto;
import course.linkflower.link.oneframework.house.service.CommunityService;
import course.linkflower.link.oneframework.house.vo.communityinfo.CommunityInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/communityinfo")
@RefreshScope
public class CommunityInfoController {
    @Autowired
    CommunityService communityService;
    @PostMapping("/add")
    public Result<CommunityInfoVo> add(@RequestBody AddDto addDto) {
        return communityService.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteDto deleteDto) {
        return communityService.delete(deleteDto);
    }

    @PostMapping("/update")
    public Result<CommunityInfoVo> update(@RequestBody UpdateDto updateDto) {
        return communityService.update(updateDto);
    }

    @PostMapping("/search")
    public Result<CommunityInfoVo> search(@RequestBody SearchDto searchDto) {
        return communityService.getById(searchDto);
    }
}
