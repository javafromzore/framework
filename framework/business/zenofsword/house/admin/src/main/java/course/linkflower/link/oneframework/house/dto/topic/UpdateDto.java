package course.linkflower.link.oneframework.house.dto.topic;

import course.linkflower.link.oneframework.house.model.Topic;
import lombok.Data;

@Data
public class UpdateDto {
    private String name;
    private String id;
    private String parentId;
    private String parent1Id;
    private byte columnType;
    private byte isHot;
    private String icon;
    private String sortValue;

    public Topic toModel(UpdateDto updateDto){
        Topic topic=new Topic();
        topic.setName(name);
        topic.setParentId(Long.parseLong(parentId));
        topic.setParent1Id(Long.parseLong(parent1Id));
        topic.setIcon(icon);
        topic.setIsHot(isHot);
        topic.setSortValue(Integer.parseInt(sortValue));
        topic.setColumnType(columnType);
        return topic;
    }
}
