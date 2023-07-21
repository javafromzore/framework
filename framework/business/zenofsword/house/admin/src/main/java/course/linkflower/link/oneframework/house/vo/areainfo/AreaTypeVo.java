package course.linkflower.link.oneframework.house.vo.areainfo;

import lombok.Data;

@Data
public class AreaTypeVo {
    private String type;
    private int level;
    private final String targetType = "rentHouse";
}
