package course.linkflower.link.oneframework.house.vo.topic;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class TopicTreeVo {
    private String name;
    private String parentId;
    private String parent1Id;
    private byte columnType;
    private byte isHot;
    private String icon;
    private int sortValue;
    private String id;
    private int level;
    private List<TopicTreeVo> childs = new ArrayList<>();

    public static TopicTreeVo loadFromList(List<TopicTreeVo> list) {
        if (list.size() > 0) {
            TopicTreeVo root = list.get(0);
            Map<String, TopicTreeVo> topicTreeVoMap = new HashMap<>();
            for (TopicTreeVo l : list) {
                topicTreeVoMap.put(l.getId(), l);
                TopicTreeVo parent = topicTreeVoMap.get(l.getParentId());
                if (parent != null) {
                    parent.childs.add(l);
                }
            }
            return root;
        }
        return null;
    }
}
