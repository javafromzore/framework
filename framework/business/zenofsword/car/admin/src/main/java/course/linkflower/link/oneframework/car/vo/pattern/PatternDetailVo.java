package course.linkflower.link.oneframework.car.vo.pattern;

import course.linkflower.link.oneframework.car.vo.config.ConfigDetailVo;
import lombok.Data;

import java.util.List;

@Data
public class PatternDetailVo {
    private String id;
    private String name;
    private String annualId;
    private String guidePrice;
    private String quotedPrice;
    private Integer ordering;
    private String seriesId;
    private List<ConfigDetailVo> configDetailVos;
}
