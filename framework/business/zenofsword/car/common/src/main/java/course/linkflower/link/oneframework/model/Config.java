package course.linkflower.link.oneframework.model;

import lombok.Data;

@Data
public class Config {
    private Long id;
    private String name;
    private String remark;
    private String icon;
    private String valueType;
    private String introduction;
    private Integer ordering;
    private String carType;
    private String configType;
}
