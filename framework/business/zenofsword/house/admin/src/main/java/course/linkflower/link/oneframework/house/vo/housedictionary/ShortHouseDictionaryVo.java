package course.linkflower.link.oneframework.house.vo.housedictionary;

import course.linkflower.link.oneframework.house.model.HouseDictionary;
import lombok.Data;

@Data
public class ShortHouseDictionaryVo {
    private String key;
    private String value;
    private String type;
    public ShortHouseDictionaryVo loadFrom(HouseDictionary houseDictionary){
        key = houseDictionary.getKey();
        value = houseDictionary.getValue();
        type = houseDictionary.getType();
        return this;
    }
}
