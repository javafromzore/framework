package course.linkflower.link.oneframework.house.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("house_device")
public class HouseDevice {
    private Long id;
    private Long rentHouseInfoId;
    private Long houseDeviceTypeId;
}
