package course.linkflower.link.system.dto.privilege;

import course.linkflower.link.oneframework.common.dto.PageDto;
import lombok.Data;

@Data
public class SearchDto extends PageDto {
    private String searchKey;
    private String type;
    private String parentId;
}
