package course.linkflower.link.system.dto.privilegegroup;

import lombok.Data;

@Data
public class UpdateDto {
    private String id;
    private String name;
    private String code;
    private int ordering;
}
