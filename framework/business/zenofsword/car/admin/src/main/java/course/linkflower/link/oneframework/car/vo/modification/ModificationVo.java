package course.linkflower.link.oneframework.car.vo.modification;

import course.linkflower.link.oneframework.model.Modification;
import lombok.Data;

@Data
public class ModificationVo {
    private String usedCarId;
    private String name;
    private String value;
    private String id;
    private String remark;
    private String valueType;
    private String introduction;
    private String valueStr;
    private Integer ordering;
    public ModificationVo loadFrom(Modification modification) {
        if (modification !=null){
            if (modification.getUsedCarId()!=null){
                usedCarId=String.valueOf(modification.getUsedCarId());
            }
            name= modification.getName();
            if (modification.getValue()!=null){
                value=String.valueOf(modification.getValue());
            }
            if (modification.getId()!=null){
                id=String.valueOf(modification.getId());
            }
            remark= modification.getRemark();
            valueType= modification.getValueType();
            introduction= modification.getIntroduction();
            valueStr= modification.getValueStr();
            ordering= modification.getOrdering();
        }
        return this;
    }
}
