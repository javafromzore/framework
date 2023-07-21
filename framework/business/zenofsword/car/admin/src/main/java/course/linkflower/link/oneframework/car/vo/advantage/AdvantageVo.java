package course.linkflower.link.oneframework.car.vo.advantage;

import course.linkflower.link.oneframework.model.Advantage;
import lombok.Data;

@Data
public class AdvantageVo {
    private String id;
    private String type;
    private String value;
    private String configId;
    private String valueStr;
    private String valueMax;

    public AdvantageVo loadFrom(Advantage advantage) {
        if (advantage!=null) {
            if (advantage.getId() != null) {
                id = String.valueOf(advantage.getId());
            }
            type = advantage.getType();
            if (advantage.getValue() != null) {
                value = String.valueOf(advantage.getValue());
            }
            if (advantage.getConfigId() != null) {
                configId = String.valueOf(advantage.getConfigId());
            }
            valueStr = advantage.getValueStr();
            if (advantage.getValueMax() != null) {
                valueMax = String.valueOf(advantage.getValueMax());
            }
        }
        return this;
    }
}
