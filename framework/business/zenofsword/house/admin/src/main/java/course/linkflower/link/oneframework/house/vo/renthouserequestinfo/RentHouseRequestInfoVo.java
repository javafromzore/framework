package course.linkflower.link.oneframework.house.vo.renthouserequestinfo;

import course.linkflower.link.oneframework.house.model.RentHouseRequestInfo;
import lombok.Data;

@Data
public class RentHouseRequestInfoVo {
    private String id;
    private String name;
    private String key;

    public RentHouseRequestInfoVo loadFrom(RentHouseRequestInfo rentHouseRequestInfo){
        if (rentHouseRequestInfo != null){
            id = String.valueOf(rentHouseRequestInfo.getId());
            name=rentHouseRequestInfo.getName();
            key = rentHouseRequestInfo.getKey();
        }
        return this;
    }
}
