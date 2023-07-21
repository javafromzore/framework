package course.linkflower.link.oneframework.house.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("house_device_type")
public class HouseDeviceType {
    private Long id;
    private String name;
    private String key;
    private String icon;
    private String type;
}
