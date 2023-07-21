package course.linkflower.link.oneframework.house.vo.househightlightinfo;

import course.linkflower.link.oneframework.house.model.HouseHightlightInfo;
import lombok.Data;

@Data
public class HouseHightlightInfoVo {
    private String id;
    private String name;
    private String key;

    public HouseHightlightInfoVo loadFrom(HouseHightlightInfo houseHightlightInfo){
        if (houseHightlightInfo!=null){
            id = String.valueOf(houseHightlightInfo.getId());
            name = houseHightlightInfo.getName();
            key = houseHightlightInfo.getName();
        }
        return this;
    }
}
