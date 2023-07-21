package course.linkflower.link.oneframework.house.service;

import course.linkflower.link.oneframework.common.model.Result;

import course.linkflower.link.oneframework.house.dto.topic.AddTopicDto;
import course.linkflower.link.oneframework.house.dto.topic.DeleteDto;
import course.linkflower.link.oneframework.house.dto.topic.UpdateTopicDto;
import course.linkflower.link.oneframework.house.vo.topic.TopicTreeVo;
import course.linkflower.link.oneframework.house.vo.topic.TopicVo;


public interface TopicService {
    Result<TopicVo> add (AddTopicDto addTopicDto);
    Result<TopicVo> update(UpdateTopicDto updateTopicDto);
    Result delete (DeleteDto deleteDto);
    Result<TopicVo> getById(long id);
    Result<TopicTreeVo> listByCode(String code);
}
