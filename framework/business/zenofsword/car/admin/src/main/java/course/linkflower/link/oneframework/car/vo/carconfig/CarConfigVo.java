package course.linkflower.link.oneframework.car.vo.carconfig;

import course.linkflower.link.oneframework.model.CarConfig;
import lombok.Data;

@Data
public class CarConfigVo {
    private String targetId;     //车系，年款，款式
    private String configId;
    private String value;
    private String valueStr;
    private String type;
    private String id;

    public CarConfigVo loadFrom(CarConfig carConfig) {
        if (carConfig != null) {
            if (carConfig.getId()!=null){
                id=String.valueOf(carConfig.getId());
            }
            if (carConfig.getValue()!=null){
                value=String.valueOf(carConfig.getValue());
            }
            valueStr= carConfig.getValueStr();
            type=carConfig.getType();
            if (carConfig.getConfigId() != null) {
                configId=String.valueOf(carConfig.getConfigId());
            }
            if (carConfig.getTargetId() == null) {
                targetId=String.valueOf(carConfig.getTargetId());
            }
        }
        return this;
    }
}
