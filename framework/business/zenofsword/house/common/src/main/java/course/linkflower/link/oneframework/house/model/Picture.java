package course.linkflower.link.oneframework.house.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("picture")
public class Picture {
    private Long id;
    private Long rentHouseInfoId;
    private String type;
    private String name;
    private String url;
}
