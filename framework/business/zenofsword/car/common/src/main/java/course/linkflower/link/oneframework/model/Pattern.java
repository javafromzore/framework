package course.linkflower.link.oneframework.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("car_pattern")
public class Pattern {
    private Long id;
    private Long seriesId;
    private Long annualId;
    private String name;
    private Long guidePrice;
    private Long quotedPrice;
    private Integer ordering;
}
