package course.linkflower.link.oneframework.house.vo.housedevicetype;

import course.linkflower.link.oneframework.house.model.HouseDeviceType;
import lombok.Data;

@Data
public class HouseDeviceTypeVo {
    private String id;
    private String name;
    private String key;
    private String icon;
    private String type;

    public HouseDeviceTypeVo loadFrom(HouseDeviceType houseDeviceType){
        if (houseDeviceType!=null){
            id = String.valueOf(houseDeviceType.getId());
            name = houseDeviceType.getName();
            key = houseDeviceType.getKey();
            icon = houseDeviceType.getIcon();
            type = houseDeviceType.getType();
        }
        return this;
    }
}
