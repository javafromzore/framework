package course.linkflower.link.system.dto.role;

import lombok.Data;

import java.util.List;

@Data
public class AddDto {
    private String name;
    private String type;
    private String code;
    private int ordering;
    private String[] priviIds;
    private Integer countLimit;
}

