package course.linkflower.link.system.vo.usergroup;

import lombok.Data;

@Data
public class UserGroupVo {
    private String id;
    private String name;
    private String type;
    private String code;
    private int ordering;
}
