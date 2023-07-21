package course.linkflower.link.oneframework.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("car_config")
public class CarConfig {

    public static final String TypeSeries = "series";
    public static final String TypeAnnualModel = "annualModel";
    public static final String TypePattern = "pattern";

    private Long targetId;     //车系，年款，款式
    private Long configId;
    private Long value;
    private String valueStr;
    private String type;
    private Long id;
}
