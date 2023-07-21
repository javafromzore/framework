package course.linkflower.link.oneframework.house.vo.renthouseinfo;

import course.linkflower.link.oneframework.house.model.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListHouseOptions {
    List<HouseDictionary> showDictionary = new ArrayList<>();
    List<AreaInfo> showAreaInfo = new ArrayList<>();
    List<HouseDeviceType> showHouseDeviceType = new ArrayList<>();
    List<HouseHightlightInfo> showHouseHightlightInfo = new ArrayList<>();
    List<RentHouseRequestInfo> showRentHouseRequestInfo = new ArrayList<>();


}
