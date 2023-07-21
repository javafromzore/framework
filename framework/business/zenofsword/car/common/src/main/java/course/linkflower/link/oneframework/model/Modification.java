package course.linkflower.link.oneframework.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("modification")
public class Modification {
    private Long usedCarId;
    private String name;
    private Long value;
    private Long id;
    private String remark;
    private String valueType;
    private String introduction;
    private String valueStr;
    private Integer ordering;
}
