package course.linkflower.link.oneframework.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("advantage")
public class Advantage {
    private Long id;
    private String type;
    private Long value;
    private Long configId;
    private String valueStr;
    private Long valueMax;
}
