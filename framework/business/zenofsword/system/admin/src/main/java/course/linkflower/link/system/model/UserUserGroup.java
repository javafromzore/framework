package course.linkflower.link.system.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("user_user_group")
public class UserUserGroup {
    private Long id;
    private Long userId;
    private Long userGroupId;
}
