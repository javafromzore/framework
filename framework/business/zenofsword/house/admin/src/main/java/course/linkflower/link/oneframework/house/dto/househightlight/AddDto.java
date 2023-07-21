package course.linkflower.link.oneframework.house.dto.househightlight;

import course.linkflower.link.oneframework.house.model.HouseHighlight;
import lombok.Data;

@Data
public class AddDto {
    private String rentHouseInfoId;
    private String highlightId;

    public HouseHighlight toModel(){
        HouseHighlight houseHighlight = new HouseHighlight();
        houseHighlight.setRentHouseInfoId(Long.parseLong(rentHouseInfoId));
        houseHighlight.setHighlightId(Long.parseLong(highlightId));
        return houseHighlight;
    }
}
