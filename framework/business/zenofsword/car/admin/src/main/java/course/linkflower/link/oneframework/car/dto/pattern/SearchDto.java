package course.linkflower.link.oneframework.car.dto.pattern;

import course.linkflower.link.oneframework.common.dto.PageDto;
import lombok.Data;

@Data
public class SearchDto extends PageDto {
    private String annualId;
    private String SearchKey;
}
