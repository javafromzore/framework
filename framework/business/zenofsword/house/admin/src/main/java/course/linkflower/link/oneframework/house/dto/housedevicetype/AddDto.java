package course.linkflower.link.oneframework.house.dto.housedevicetype;

import course.linkflower.link.oneframework.house.model.HouseDeviceType;
import lombok.Data;

@Data
public class AddDto {
    private String name;
    private String key;
    private String icon;
    private String type;

    public HouseDeviceType toModel(){
        HouseDeviceType houseDeviceType = new HouseDeviceType();
        houseDeviceType.setName(name);
        houseDeviceType.setKey(key);
        houseDeviceType.setIcon(icon);
        houseDeviceType.setType(type);
        return  houseDeviceType;
    }
}
