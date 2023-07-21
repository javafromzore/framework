package course.linkflower.link.oneframework.house.dto.renthouserequestinfo;

import course.linkflower.link.oneframework.house.model.RentHouseRequestInfo;
import lombok.Data;

@Data
public class UpdateDto {
    private String id;
    private String name;
    private String key;

    public RentHouseRequestInfo toModel(){
        RentHouseRequestInfo rentHouseRequestInfo = new RentHouseRequestInfo();
        rentHouseRequestInfo.setId(Long.parseLong(id));
        rentHouseRequestInfo.setName(name);
        rentHouseRequestInfo.setKey(key);
        return  rentHouseRequestInfo;
    }
}
