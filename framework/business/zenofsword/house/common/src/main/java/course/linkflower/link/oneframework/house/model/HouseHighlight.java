package course.linkflower.link.oneframework.house.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("house_highlight")
public class HouseHighlight {
    private Long id;
    private Long rentHouseInfoId;
    private Long highlightId;
}
