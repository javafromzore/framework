package course.linkflower.link.system.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("role_repulsion")
public class RoleRepulsion {
    private Long id;
    private Long roleIdA;
    private Long roleIdB;
    private String remark;
}
