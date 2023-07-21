package course.linkflower.link.oneframework.car.dto.carconfig;

import course.linkflower.link.oneframework.model.CarConfig;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;


@Data
public class OtherUseDto {
    private String configId;
    private String  value;
    private String valueStr;
    public CarConfig toCarConfig(Long targetId,String type) {
        CarConfig carConfig = new CarConfig();
        if (StringUtils.isNotEmpty(configId)) {
            carConfig.setConfigId(Long.valueOf(configId));
        }
        if (StringUtils.isNotEmpty(value)){
            carConfig.setValue(Long.valueOf(value));
        }
        carConfig.setValueStr(valueStr);
        carConfig.setTargetId(targetId);
        carConfig.setType(type);
        return carConfig;
    }
}
