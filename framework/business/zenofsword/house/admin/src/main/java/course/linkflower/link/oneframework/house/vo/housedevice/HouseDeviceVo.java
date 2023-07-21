package course.linkflower.link.oneframework.house.vo.housedevice;

import course.linkflower.link.oneframework.house.model.HouseDevice;
import lombok.Data;

@Data
public class HouseDeviceVo {
    private String id;
    private String rentHouseInfoId;
    private String houseDeviceTypeId;

    public HouseDeviceVo loadFrom(HouseDevice houseDevice){
        if (houseDevice!=null){
            id = String.valueOf(houseDevice.getId());
            rentHouseInfoId = String.valueOf(houseDevice.getRentHouseInfoId());
            houseDeviceTypeId = String.valueOf(houseDevice.getHouseDeviceTypeId());
        }
        return this;
    }
}
