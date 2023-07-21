package course.linkflower.link.oneframework.house.dto.housedictionary;

import course.linkflower.link.oneframework.house.model.HouseDictionary;
import lombok.Data;

@Data
public class AddDto {
    private String type;
    private String key;
    private String value;
    private Integer sortValue;

    public HouseDictionary toModel(){
        HouseDictionary houseDictionary = new HouseDictionary();
        houseDictionary.setType(type);
        houseDictionary.setKey(key);
        houseDictionary.setValue(value);
        houseDictionary.setSortValue(sortValue);
        return houseDictionary;
    }
}
