package course.linkflower.link.system.dto.privilege;

import lombok.Data;

@Data
public class UpdateDto {
    private String id;
    private String name;
    private String remark;
    private String code;
    private int ordering;
}
