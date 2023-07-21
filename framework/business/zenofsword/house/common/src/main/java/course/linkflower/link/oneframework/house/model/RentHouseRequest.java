package course.linkflower.link.oneframework.house.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("rent_house_request")
public class RentHouseRequest {
    private Long id;
    private Long rentHouseRequestInfoId;
    private Long rentHouseInfoId;
}
