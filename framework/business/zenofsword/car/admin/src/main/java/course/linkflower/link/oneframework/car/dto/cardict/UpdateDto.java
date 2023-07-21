package course.linkflower.link.oneframework.car.dto.cardict;

import course.linkflower.link.oneframework.model.CarDict;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class UpdateDto {
    private String id;
    private String value;
    private String key;
    public CarDict toCarDict(UpdateDto updateDto) {
        CarDict carDict =new CarDict();
        if (StringUtils.isNotEmpty(updateDto.getId())){
            carDict.setId(Long.valueOf(updateDto.getId()));
        }
        if (StringUtils.isNotEmpty(updateDto.getValue())){
            carDict.setValue(updateDto.getValue());
        }
        if(StringUtils.isNotEmpty(updateDto.getKey())){
            carDict.setKey(updateDto.getKey());
        }
        return carDict;
    }
}
