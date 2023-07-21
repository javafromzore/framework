package course.linkflower.link.oneframework.house.service.impl;

import course.linkflower.link.oneframework.common.constant.BaseErrorContst;
import course.linkflower.link.oneframework.common.lang.Lang;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dao.TopicMapper;
import course.linkflower.link.oneframework.house.dto.topic.AddTopicDto;
import course.linkflower.link.oneframework.house.dto.topic.DeleteDto;
import course.linkflower.link.oneframework.house.dto.topic.UpdateTopicDto;
import course.linkflower.link.oneframework.house.model.Topic;
import course.linkflower.link.oneframework.house.service.TopicService;
import course.linkflower.link.oneframework.house.vo.topic.TopicTreeVo;
import course.linkflower.link.oneframework.house.vo.topic.TopicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicMapper topicMapper;

    @Override
    public Result<TopicVo> add(AddTopicDto addTopicDto) {
        Topic t = addTopicDto.toModel();
        if (t.getCode() != null) {
            if (topicMapper.countByCode(t.getCode()) != 0) {
                return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,
                        String.format(Lang.T(BaseErrorContst.BaseMsgTimeParamsDuplicateError), "code"));
            }
        }
        topicMapper.save(t);
        return Result.succeed(new TopicVo().loadFrom(t));
    }

    @Override
    public Result<TopicVo> update(@Validated UpdateTopicDto updateTopicDto) {
        Topic t = updateTopicDto.toModel();
        if (t.getCode() != null) {
            if (topicMapper.countByCodeAndId(t.getCode(), t.getId()) != 0) {
                return Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,
                        String.format(Lang.T(BaseErrorContst.BaseMsgTimeParamsDuplicateError), "code"));
            }
        }
        topicMapper.update(t);
        return Result.succeed(new TopicVo().loadFrom(t));
    }

    @Override
    public Result delete(DeleteDto deleteDto) {
        topicMapper.delete(Long.parseLong(deleteDto.getId()));
        return Result.succeed();
    }

    @Override
    public Result<TopicVo> getById(long id) {

        return Result.succeed();
    }

    @Override
    public Result<TopicTreeVo> listByCode(String code) {
        List<TopicTreeVo> topics = topicMapper.listByParentCode(code);
        return Result.succeed(TopicTreeVo.loadFromList(topics));
    }
}