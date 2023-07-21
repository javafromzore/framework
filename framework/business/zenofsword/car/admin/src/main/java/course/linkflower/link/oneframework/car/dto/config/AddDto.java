package course.linkflower.link.oneframework.car.dto.config;

import course.linkflower.link.oneframework.model.Config;
import lombok.Data;

@Data
public class AddDto {
    private String name;
    private String remark;
    private String icon;
    private String valueType;
    private String introduction;
    private Integer ordering;
    private String carType;
    private String configType;

    public Config toCarAttrib() {
        Config config =new Config();
        config.setName(name);
        config.setRemark(remark);
        config.setIcon(icon);
        config.setValueType(valueType);
        config.setIntroduction(introduction);
        config.setOrdering(ordering);
        config.setConfigType(configType);
        config.setCarType(carType);
        return config;
    }
}
