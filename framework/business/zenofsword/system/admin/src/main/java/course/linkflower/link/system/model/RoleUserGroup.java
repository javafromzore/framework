package course.linkflower.link.system.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("role_user_group")
public class RoleUserGroup {
    private Long id;
    private Long roleId;
    private Long userGroupId;
}
