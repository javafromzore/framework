package course.linkflower.link.oneframework.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("pattern_photo")
public class PatternPhoto {
    private Long id;
    private Long patternId;
    private String photo;
    private Integer ordering;
}
