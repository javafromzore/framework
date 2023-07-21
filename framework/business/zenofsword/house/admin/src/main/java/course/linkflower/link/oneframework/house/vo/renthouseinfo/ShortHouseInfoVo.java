package course.linkflower.link.oneframework.house.vo.renthouseinfo;

import course.linkflower.link.oneframework.house.model.RentHouseInfo;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class ShortHouseInfoVo {
    private String id;
    private String clientId;
    private String title;
    private int rent;
    private int level;
    private int status;

    public ShortHouseInfoVo loadFrom(RentHouseInfo rentHouseInfo){
        id = String.valueOf(rentHouseInfo.getId());
        if (rentHouseInfo.getClientId()!=0){
            clientId = String.valueOf(rentHouseInfo.getClientId());
        }
        title = rentHouseInfo.getTitle();
        rent = rentHouseInfo.getRent();
        level = rentHouseInfo.getLevel();
        status = rentHouseInfo.getStatus();
        return this;
    }
}
