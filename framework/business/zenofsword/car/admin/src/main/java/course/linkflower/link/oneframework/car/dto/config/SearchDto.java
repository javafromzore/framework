package course.linkflower.link.oneframework.car.dto.config;

import course.linkflower.link.oneframework.common.dto.PageDto;
import lombok.Data;

@Data
public class SearchDto extends PageDto {
    private String type;
    private String searchKey;

}
