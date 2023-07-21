package course.linkflower.link.system.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("user_role")
public class UserRole {
    private Long id;
    private Long userId;
    private Long role;
}
