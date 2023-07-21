package course.linkflower.link.system.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("privilege_group")
public class PrivilegeGroup {
    private Long id;
    private String name;
    private String type;
    private String code;
    private int ordering;
}
