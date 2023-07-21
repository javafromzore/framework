package course.linkflower.link.oneframework.house.vo.topic;

import course.linkflower.link.oneframework.house.model.Topic;
import lombok.Data;

@Data
public class TopicVo {
    private String id;
    private String name;
    private String parentId;
    private String parent1Id;
    private int columnType;
    private int isHot;
    private int sortValue;
    private String icon;
    public TopicVo loadFrom(Topic t){
        if(t!=null){
            id = String.valueOf(t.getId());
            name = t.getName();
            parentId = String.valueOf(t.getParentId());
            parent1Id = String.valueOf(t.getParent1Id());
            columnType = t.getColumnType();
            isHot = t.getIsHot();
            sortValue = t.getSortValue();
            icon = t.getIcon();
        }
        return this;
    }
}
