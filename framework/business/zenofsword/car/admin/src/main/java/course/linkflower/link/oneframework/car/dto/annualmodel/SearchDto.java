package course.linkflower.link.oneframework.car.dto.annualmodel;

import course.linkflower.link.oneframework.common.model.PageResult;
import lombok.Data;

@Data
public class SearchDto extends PageResult {
    private String searchKey;
    private String seriesId;
}

