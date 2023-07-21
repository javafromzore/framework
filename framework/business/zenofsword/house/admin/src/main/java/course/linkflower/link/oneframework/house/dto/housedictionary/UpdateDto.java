package course.linkflower.link.oneframework.house.dto.housedictionary;

import course.linkflower.link.oneframework.house.model.HouseDictionary;
import lombok.Data;

@Data
public class UpdateDto {
    private String id ;
    private String type;
    private String key;
    private String value;
    public HouseDictionary toModel(){
        HouseDictionary houseDictionary = new HouseDictionary();
        houseDictionary.setId(Long.parseLong(id));
        houseDictionary.setType(type);
        houseDictionary.setKey(key);
        houseDictionary.setValue(value);
        return houseDictionary;
    }
}
