package course.linkflower.link.oneframework.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("car_infor")
public class Series {
    private Long id;
    private Long companyId;
    private String name;
    private Long brandId;
    private Integer ordering;
}
