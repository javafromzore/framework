package course.linkflower.link.oneframework.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("dict")
public class Dict {
    private Long id;
    private String value;
    private String key;
    private String type;
    private Integer ordering;
}
