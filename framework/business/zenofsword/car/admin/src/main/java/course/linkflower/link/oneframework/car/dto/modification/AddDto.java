package course.linkflower.link.oneframework.car.dto.modification;

import course.linkflower.link.oneframework.model.Modification;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class AddDto {
    private String usedCarId;
    private String name;
    private String value;
    private String remark;
    private String valueType;
    private String introduction;
    private String valueStr;
    private Integer ordering;

    public Modification toModification() {
        Modification modification =new Modification();
        if (StringUtils.isNotEmpty(usedCarId)){
            modification.setUsedCarId(Long.valueOf(usedCarId));
        }
        modification.setName(name);
        if (StringUtils.isNotEmpty(value)){
            modification.setValue(Long.valueOf(value));
        }
        modification.setRemark(remark);
        modification.setValueType(valueType);
        modification.setIntroduction(introduction);
        modification.setValueStr(valueStr);
        modification.setOrdering(ordering);
        return modification;
    }
}
