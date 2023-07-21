package course.linkflower.link.oneframework.house.vo.renthouseinfo;

import course.linkflower.link.oneframework.house.model.RentHouseInfo;
import lombok.Data;

import java.util.*;

@Data
public class RentHouseInfoVo {
    private String id;
    private String clientId;
    private String agentId;
    private String communityInfoId;
    private String commissionId;
    private String depositTypeId;
    private String rentHouseTypeId;
    private String decorateTypeId;
    private String orientationId;
    private String storeyId;
    private String bedroomTypeId;
    private double propertyPrice;
    private double houseSize;
    private int bedroom;
    private int livingroom;
    private int washroom;
    private int storey;
    private int rent;
    private int status;
    private int level;
    private String houseDescription;
    private String picture;
    private String video;
    private String title;
    private String address;

    public RentHouseInfoVo loadFrom(RentHouseInfo r){
        if (r != null){
            id = String.valueOf(r.getId());
            clientId = String.valueOf(r.getClientId());
            agentId = String.valueOf(r.getAgentId());
            communityInfoId = String.valueOf(r.getCommunityInfoId());
            depositTypeId = String.valueOf(r.getDepositTypeId());
            commissionId = String.valueOf(r.getCommissionId());
            rentHouseTypeId = String.valueOf(r.getRentHouseTypeId());
            decorateTypeId = String.valueOf(r.getDecorateTypeId());
            orientationId = String.valueOf(r.getOrientationId());
            storeyId = String.valueOf(r.getStoreyId());
            bedroomTypeId = String.valueOf(r.getBedroomTypeId());
            propertyPrice = r.getPropertyPrice();
            houseSize = r.getHouseSize();
            bedroom = r.getBedroom();
            storey = r.getStorey();
            livingroom = r.getLivingroom();
            washroom = r.getWashroom();
            rent = r.getRent();
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

    public List<RentHouseInfoVo> loadFromList(Collection<RentHouseInfo> list) {
        List<RentHouseInfoVo> ret = new ArrayList<>();
        Map<Long, Boolean> dictIdMap = new HashMap<>();
        for (RentHouseInfo l : list) {
            if (l.getCommunityInfoId() != null) {
                dictIdMap.put(l.getCommunityInfoId(), Boolean.TRUE);
            }
            if (l.getCommunityInfoId() != null) {
                dictIdMap.put(l.getCommunityInfoId(), Boolean.TRUE);
            }
            if (l.getCommunityInfoId() != null) {
                dictIdMap.put(l.getCommunityInfoId(), Boolean.TRUE);
            }
            if (l.getCommunityInfoId() != null) {
                dictIdMap.put(l.getCommunityInfoId(), Boolean.TRUE);
            }
            if (l.getCommunityInfoId() != null) {
                dictIdMap.put(l.getCommunityInfoId(), Boolean.TRUE);
            }
        }
        return ret;
    }
}
