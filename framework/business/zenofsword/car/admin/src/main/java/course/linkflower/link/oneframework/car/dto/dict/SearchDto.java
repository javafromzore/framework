package course.linkflower.link.oneframework.car.dto.dict;

import course.linkflower.link.oneframework.common.dto.PageDto;
import lombok.Data;

@Data
public class SearchDto extends PageDto {
    private String Type;
    private String SearchKey;
}
