package course.linkflower.link.oneframework.house.controller;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.base.CodeDto;

import course.linkflower.link.oneframework.house.dto.topic.AddTopicDto;
import course.linkflower.link.oneframework.house.dto.topic.DeleteDto;
import course.linkflower.link.oneframework.house.dto.topic.SearchDto;
import course.linkflower.link.oneframework.house.dto.topic.UpdateTopicDto;
import course.linkflower.link.oneframework.house.service.TopicService;
import course.linkflower.link.oneframework.house.vo.topic.TopicTreeVo;
import course.linkflower.link.oneframework.house.vo.topic.TopicVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/topic")
@RefreshScope
public class TopicController {
    @Autowired
    TopicService topicService;
    @PostMapping("/add")
    public Result<TopicVo> add(@Validated @RequestBody AddTopicDto addTopicDto) {
        return topicService.add(addTopicDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteDto deleteDto) {
        return topicService.delete(deleteDto);
    }

    @PostMapping("/update")
    public Result<TopicVo> update(@RequestBody UpdateTopicDto updateTopicDto) {
        return topicService.update(updateTopicDto);
    }

    @PostMapping("/search")
    public Result<TopicVo> search(@RequestBody SearchDto searchDto) {
        return topicService.getById(Long.parseLong(searchDto.getId()));
    }
    @PostMapping("/listByCode")
    public Result<TopicTreeVo> listByCode(@RequestBody CodeDto codeDto){
        return topicService.listByCode(codeDto.getCode());
    }
}
