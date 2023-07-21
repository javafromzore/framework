package course.linkflower.link.system.vo.privilegegroup;

import lombok.Data;

@Data
public class PrivilegeGroupVo {
    private String id;
    private String name;
    private String type;
    private String code;
    private int ordering;
}
