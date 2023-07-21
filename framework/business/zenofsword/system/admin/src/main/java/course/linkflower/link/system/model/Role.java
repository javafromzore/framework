package course.linkflower.link.system.model;

import com.alibaba.druid.support.ibatis.SpringIbatisBeanNameAutoProxyCreator;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("role")
public class Role {
    private Long id;
    private String name;
    private String type;
    private String code;
    private int ordering;
    private int count;
    private Integer countLimit;
}
