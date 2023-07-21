package course.linkflower.link.oneframework.car.dto.pattern;

import course.linkflower.link.oneframework.car.dto.carconfig.OtherUseDto;
import lombok.Data;

import java.util.List;

@Data
public class UpdateDto {
    private String id;
    private String name;
    private String guidePrice;
    private String quotedPrice;
    private Integer ordering;
    private String annualId;
    private List<OtherUseDto> otherUseDtos;
}
