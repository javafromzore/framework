package course.linkflower.link.system.vo.privilege;

import lombok.Data;

@Data
public class PrivilegeVo {
    private String id;
    private String name;
    private String type;
    private String remark;
    private String parentId;
    private String code;
    private int ordering;
}
