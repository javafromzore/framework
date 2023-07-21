package course.linkflower.link.oneframework.car.dto.dict;

import course.linkflower.link.oneframework.model.Dict;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
@Data
public class AddDto {
    private String id;
    private String value;
    private String key;
    private String type;
    private Integer ordering;

    public Dict toDict(AddDto addDto) {
        Dict dict =new Dict();
        if (StringUtils.isNotEmpty(addDto.getValue())){
            dict.setValue(addDto.getValue());
        }
        if(StringUtils.isNotEmpty(addDto.getKey())){
            dict.setKey(addDto.getKey());
        }
        if (StringUtils.isNotEmpty(addDto.getType())) {
            dict.setType(addDto.getType());
        }
        if (ordering!=null) {
            dict.setOrdering(Integer.valueOf(ordering));
        }
        return dict;
    }
}
