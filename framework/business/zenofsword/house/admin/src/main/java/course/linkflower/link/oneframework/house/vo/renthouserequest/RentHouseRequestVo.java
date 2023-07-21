package course.linkflower.link.oneframework.house.vo.renthouserequest;

import course.linkflower.link.oneframework.house.model.RentHouseRequest;
import lombok.Data;

@Data
public class RentHouseRequestVo {
    private String id;
    private String rentHouseRequestInfoId;
    private String rentHouseInfoId;

    public RentHouseRequestVo loadFrom(RentHouseRequest rentHouseRequest){
        if (rentHouseRequest!=null){
            id=String.valueOf(rentHouseRequest.getId());
            rentHouseRequestInfoId = String.valueOf(rentHouseRequest.getRentHouseRequestInfoId());
            rentHouseInfoId = String.valueOf(rentHouseRequest.getRentHouseInfoId());
        }
        return this;
    }
}
