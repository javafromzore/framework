package course.linkflower.link.oneframework.house.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("rent_house_request_info")
public class RentHouseRequestInfo {
        private Long id;
        private String name;
        private String key;
}
