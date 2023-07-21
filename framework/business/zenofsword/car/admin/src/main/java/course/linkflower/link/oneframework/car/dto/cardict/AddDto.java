package course.linkflower.link.oneframework.car.dto.cardict;

import course.linkflower.link.oneframework.model.CarDict;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class AddDto {
    private String value;
    private String key;
    private String type;
    private Integer ordering;

    public CarDict toCarDict(AddDto addDto) {
        CarDict carDict =new CarDict();
        if (StringUtils.isNotEmpty(addDto.getValue())){
            carDict.setValue(addDto.getValue());
        }
        if(StringUtils.isNotEmpty(addDto.getKey())){
            carDict.setKey(addDto.getKey());
        }
        if (StringUtils.isNotEmpty(addDto.getType())) {
            carDict.setType(addDto.getType());
        }
            carDict.setOrdering(ordering);
        return carDict;
    }
}
