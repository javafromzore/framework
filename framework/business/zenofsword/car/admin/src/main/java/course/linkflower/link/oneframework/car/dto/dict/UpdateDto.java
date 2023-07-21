package course.linkflower.link.oneframework.car.dto.dict;

import course.linkflower.link.oneframework.model.Dict;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
@Data

public class UpdateDto {
    private String id;
    private String value;
    private String key;
    private String type;
    private Integer ordering;

    public Dict toDict(UpdateDto updateDto) {
        Dict dict =new Dict();
        if (StringUtils.isNotEmpty(updateDto.getId())){
            dict.setId(Long.valueOf(updateDto.getId()));
        }
        if (StringUtils.isNotEmpty(updateDto.getValue())){
            dict.setValue(updateDto.getValue());
        }
        if(StringUtils.isNotEmpty(updateDto.getKey())){
            dict.setKey(updateDto.getKey());
        }
        if (StringUtils.isNotEmpty(updateDto.getType())) {
            dict.setType(updateDto.getType());
        }
        dict.setOrdering(ordering);
        return dict;
    }
}
