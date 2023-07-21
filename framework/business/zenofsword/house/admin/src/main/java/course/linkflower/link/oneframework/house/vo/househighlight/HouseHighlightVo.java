package course.linkflower.link.oneframework.house.vo.househighlight;

import course.linkflower.link.oneframework.house.model.HouseHighlight;
import lombok.Data;

@Data
public class HouseHighlightVo {
    private String id;
    private String rentHouseInfoId;
    private String highlightId;

    public HouseHighlightVo loadFrom(HouseHighlight houseHighlight){
            if (houseHighlight!=null){
                id = String.valueOf(houseHighlight.getId());
                rentHouseInfoId= String.valueOf(houseHighlight.getRentHouseInfoId());
                highlightId = String.valueOf(houseHighlight.getHighlightId());
            }
        return this;
    }
}
