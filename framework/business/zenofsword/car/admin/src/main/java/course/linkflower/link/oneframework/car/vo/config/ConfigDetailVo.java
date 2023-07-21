package course.linkflower.link.oneframework.car.vo.config;


import lombok.Data;

@Data
public class ConfigDetailVo {
    //config的全部信息
    private String id;
    private String name;
    private String remark;
    private String icon;
    private String valueType;
    private String introduction;
    private Long ordering;
    private String carType;
    private String configType;
    //carConfig的全部信息
    private Long value;
    private String valueStr;
    private String middleId;
}
