package course.linkflower.link.oneframework.house.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * @author xxx
 * @date 2019/7/30
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("user_member")
public class Member extends Model<Member> {
	private Long id;
	private String name;
	private String account;
	private String mail;
	private String password;
	private int status; // 0, 1, 2

}
