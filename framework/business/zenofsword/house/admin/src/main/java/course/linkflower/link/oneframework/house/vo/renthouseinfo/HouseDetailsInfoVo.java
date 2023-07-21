package course.linkflower.link.oneframework.house.vo.renthouseinfo;

import course.linkflower.link.oneframework.house.model.HouseDictionary;
import course.linkflower.link.oneframework.house.model.RentHouseInfo;
import course.linkflower.link.oneframework.house.vo.areainfo.AreaInfoVo;
import course.linkflower.link.oneframework.house.vo.commission.CommissionVo;
import course.linkflower.link.oneframework.house.vo.communityinfo.CommunityInfoVo;
import course.linkflower.link.oneframework.house.vo.housedevicetype.HouseDeviceTypeInfoVo;
import course.linkflower.link.oneframework.house.vo.housedevicetype.HouseDeviceTypeVo;
import course.linkflower.link.oneframework.house.vo.housedictionary.HouseDictionaryVo;
import course.linkflower.link.oneframework.house.vo.househightlightinfo.HouseHightlightInfoVo;
import course.linkflower.link.oneframework.house.vo.renthouserequestinfo.RentHouseRequestInfoVo;
import lombok.Data;

import java.util.List;

@Data
public class HouseDetailsInfoVo {
    private String id;
    private String title;
    private int rent;
    private String picture;
    private String video;
    private String address;
    private String commission;
    private CommissionVo commissionVo;
    private List<AreaInfoVo> houseAreaInfoVos;
    private List<HouseDictionaryVo> houseDictionaryVos;
    private List<HouseDeviceTypeVo> houseDeviceTypeVos;
    private List<HouseHightlightInfoVo> houseHightlightInfoVos;
    private List<RentHouseRequestInfoVo> rentHouseRequestInfoVos;
    private CommunityInfoVo communityInfoVo;
    private double propertyPrice;
    private double houseSize;
    private int bedroom;
    private int livingroom;
    private int washroom;
    private int status;
    private int level;
    private int storey;
    private String houseDescription;


    public HouseDetailsInfoVo loadFrom(RentHouseInfo r){
        if (r!=null){
            id = String.valueOf(r.getId());
            propertyPrice = r.getPropertyPrice();
            houseSize = r.getHouseSize();
            bedroom = r.getBedroom();
            livingroom = r.getLivingroom();
            washroom = r.getWashroom();
            rent = r.getRent();
            storey = r.getStorey();
            status = r.getStatus();
            level = r.getLevel();
            houseDescription = r.getHouseDescription();
            picture = r.getPicture();
            video = r.getVideo();
            title = r.getTitle();
            address = r.getAddress();

        }
        return this;
    }

    public HouseDetailsInfoVo listAllData(){

        return this;
    }
}
