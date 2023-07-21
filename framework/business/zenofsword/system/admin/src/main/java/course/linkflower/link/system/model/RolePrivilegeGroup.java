package course.linkflower.link.system.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("role_privilege_group")
public class RolePrivilegeGroup {
    private Long id;
    private Long priviGroupId;
    private Long roleId;
}
