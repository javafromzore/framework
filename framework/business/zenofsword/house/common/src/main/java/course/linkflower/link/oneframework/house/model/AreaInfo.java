package course.linkflower.link.oneframework.house.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("area_info")
public class AreaInfo {
    private Long id;
    private Long parentId;
    private int level;
    private String name;
    private String code;
    private String type;
    private String address;
}
