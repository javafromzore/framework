package course.linkflower.link.oneframework.house.vo.housedictionary;

import course.linkflower.link.oneframework.house.model.HouseDictionary;
import lombok.Data;

@Data
public class HouseDictionaryTypeVo {
    private String type;

    public HouseDictionaryTypeVo loadFrom(HouseDictionary houseDictionary){
        type = houseDictionary.getType();
        return this;
    }
}
