package course.linkflower.link.oneframework.car.vo.config;

import course.linkflower.link.oneframework.model.Config;
import lombok.Data;

@Data
public class ConfigVo {
    private String id;
    private String name;
    private String remark;
    private String icon;
    private String valueType;
    private String introduction;
    private String ordering;
    private String carType;
    private String configType;
    public ConfigVo loadFrom(Config config) {
        if (config != null) {
            if (config.getId() != null) {
                id = String.valueOf(config.getId());
            }
            name = config.getName();
            remark = config.getRemark();
            icon = config.getIcon();
            valueType = config.getValueType();
            introduction = config.getIntroduction();
            if (config.getOrdering() != null) {
                ordering = String.valueOf(config.getOrdering());
            }
            carType=config.getCarType();
            configType=config.getConfigType();
        }
        return this;
    }
}
