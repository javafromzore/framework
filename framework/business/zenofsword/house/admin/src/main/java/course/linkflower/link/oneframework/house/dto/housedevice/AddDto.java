package course.linkflower.link.oneframework.house.dto.housedevice;

import course.linkflower.link.oneframework.house.model.HouseDevice;
import lombok.Data;

@Data
public class AddDto {
    private String rentHouseInfoId;
    private String houseDeviceTypeId;

    public HouseDevice toModel(){
        HouseDevice houseDevice = new HouseDevice();
        houseDevice.setRentHouseInfoId(Long.parseLong(rentHouseInfoId));
        houseDevice.setHouseDeviceTypeId(Long.parseLong(houseDeviceTypeId));
        return  houseDevice;
    }
}
