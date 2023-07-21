package course.linkflower.link.system.dto.privilegegroup;

import lombok.Data;

@Data
public class AddDto {
    private String name;
    private String type;
    private String code;
    private int ordering;
    private String[] priviIds;
}
