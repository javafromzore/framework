package course.linkflower.link.oneframework.house.vo.housedevicetype;

import course.linkflower.link.oneframework.house.model.HouseDeviceType;
import lombok.Data;

@Data
public class HouseDeviceTypeInfoVo {
    private String id;
    private String name;
    private String icon;

    public HouseDeviceTypeInfoVo loadFrom(HouseDeviceType houseDeviceType){
        if (houseDeviceType!=null){
            id = String.valueOf(houseDeviceType.getId());
            name = houseDeviceType.getName();
            icon = houseDeviceType.getIcon();
        }
        return this;
    }
}
