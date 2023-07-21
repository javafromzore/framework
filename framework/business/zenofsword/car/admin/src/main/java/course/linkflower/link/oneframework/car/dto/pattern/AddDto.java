package course.linkflower.link.oneframework.car.dto.pattern;

import course.linkflower.link.oneframework.car.dto.carconfig.OtherUseDto;
import lombok.Data;

import java.util.List;

@Data
public class AddDto {
    private String name;
    private String annualId;
    private String guidePrice;
    private String quotedPrice;
    private Integer ordering;
    private String seriesId;
    private List<OtherUseDto> otherUseDtos;
}
