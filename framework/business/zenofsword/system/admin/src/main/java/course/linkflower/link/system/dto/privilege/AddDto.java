package course.linkflower.link.system.dto.privilege;

import lombok.Data;

@Data
public class AddDto {
    private String name;
    private String type;
    private String remark;
    private String parentId;
    private String code;
    private int ordering;
}
