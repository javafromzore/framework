package course.linkflower.link.oneframework.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("used_car_photo")
public class UsedCarPhoto {
    private Long id;
    private Long usedCarId;
    private String photo;
    private Integer ordering;
}
