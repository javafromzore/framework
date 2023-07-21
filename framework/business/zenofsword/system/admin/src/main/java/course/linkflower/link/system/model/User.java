package course.linkflower.link.system.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String account;
    private String password;
}
