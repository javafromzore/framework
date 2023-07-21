package course.linkflower.link.oneframework.house.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("housedictionary")
public class HouseDictionary {
    private Long id;
    private String type;
    private String key;
    private String value;
    private Integer sortValue;
}
