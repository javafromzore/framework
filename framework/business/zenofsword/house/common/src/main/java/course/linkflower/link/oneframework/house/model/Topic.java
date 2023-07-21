package course.linkflower.link.oneframework.house.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("topic")
public class Topic {
    private long id;
    private String name;
    private long parentId;
    private long parent1Id;
    private int columnType;
    private int isHot;
    private int sortValue;
    private String icon;
    private String code;
}
