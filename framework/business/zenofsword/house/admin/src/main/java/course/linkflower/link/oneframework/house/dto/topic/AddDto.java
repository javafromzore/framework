package course.linkflower.link.oneframework.house.dto.topic;

import course.linkflower.link.oneframework.house.model.Topic;
import lombok.Data;
import org.apache.commons.math3.analysis.function.Add;

@Data
public class AddDto {
    private String id;
    private String name;
    private String parentId;
    private String parent1Id;
    private byte columnType;
    private byte isHot;
    private String icon;
    private String sortValue;

    public Topic toModel(AddDto addDto){
        Topic topic=new Topic();
        topic.setName(name);
        if (parentId!=null) {
            topic.setParentId(Long.parseLong(parentId));
        }
        if (parent1Id!=null) {
            topic.setParentId(Long.parseLong(parent1Id));
        }
        topic.setIcon(icon);
        topic.setIsHot(isHot);
        if ((sortValue!=null)) {
            topic.setSortValue(Integer.parseInt(sortValue));
        }else {
            topic.setSortValue(0);
        }
        topic.setColumnType(columnType);
        return topic;
    }
}
