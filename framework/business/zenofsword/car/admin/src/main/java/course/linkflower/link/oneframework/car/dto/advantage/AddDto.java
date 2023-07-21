package course.linkflower.link.oneframework.car.dto.advantage;

import course.linkflower.link.oneframework.model.Advantage;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class AddDto {
    private String type;
    private String value;
    private String configId;
    private String valueStr;
    private String valueMax;

    public Advantage toAdvantage() {
        Advantage advantage =new Advantage();
        advantage.setType(type);
        if (StringUtils.isNotEmpty(value)) {
            advantage.setValue(Long.valueOf(value));
        }
        if (StringUtils.isNotEmpty(configId)){
            advantage.setConfigId(Long.valueOf(configId));
        }
        advantage.setValueStr(valueStr);
        if (StringUtils.isNotEmpty(valueMax)) {
            advantage.setValueMax(Long.valueOf(valueMax));
        }
        return advantage;
    }
}
