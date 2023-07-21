package course.linkflower.link.oneframework.house.dto.renthouseinfo;

import course.linkflower.link.oneframework.house.model.RentHouseInfo;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class AddDto {
    private String id;
    private String clientId;
    private String agentId;
    private int rent;
    private double houseSize;
    private int storey;
    private int bedroom;
    private int livingroom;
    private int washroom;
    private String communityInfoId;
    private String commissionId;
    private String depositTypeId;
    private String rentHouseTypeId;
    private String decorateTypeId;
    private String orientationId;
    private String storeyId;
    private String bedroomTypeId;
    private String[] areaInfoIds;
    private String[] deviceIds;
    private String[] highlightInfoIds;
    private String[] rentRequestInfoIds;
    private double propertyPrice;
    private int status;
    private int level;
    private String houseDescription;
    private String picture;
    private String video;
    private String title;
    private String address;
    private String searchKey;
    public RentHouseInfo toModel(){
        RentHouseInfo r = new RentHouseInfo();
        if (!StringUtils.isEmpty(id)) {
            r.setId(Long.parseLong(id));
        }
        if (!StringUtils.isEmpty(clientId)) {
            r.setClientId(Long.parseLong(clientId));
        }
        if (!StringUtils.isEmpty(agentId)) {
            r.setAgentId(Long.parseLong(agentId));
        }
        if (!StringUtils.isEmpty(communityInfoId)) {
            r.setCommunityInfoId(Long.parseLong(communityInfoId));
        }
        if (!StringUtils.isEmpty(depositTypeId)) {
            r.setDepositTypeId(Long.parseLong(depositTypeId));
        }
        if (!StringUtils.isEmpty(commissionId)) {
            r.setCommissionId(Long.parseLong(commissionId));
        }
        if (!StringUtils.isEmpty(rentHouseTypeId)) {
            r.setRentHouseTypeId(Long.parseLong(rentHouseTypeId));
        }
        if (!StringUtils.isEmpty(decorateTypeId)) {
            r.setDecorateTypeId(Long.parseLong(decorateTypeId));
        }
        if (!StringUtils.isEmpty(orientationId)) {
            r.setOrientationId(Long.parseLong(orientationId));
        }
        if (!StringUtils.isEmpty(storeyId)) {
            r.setStoreyId(Long.parseLong(storeyId));
        }
        if (!StringUtils.isEmpty(bedroomTypeId)) {
            r.setStoreyId(Long.parseLong(bedroomTypeId));
        }
        r.setPropertyPrice(propertyPrice);
        r.setHouseSize(houseSize);
        r.setBedroom(bedroom);
        r.setLivingroom(livingroom);
        r.setWashroom(washroom);
        r.setRent(rent);
        r.setStorey(storey);
        r.setStatus(status);
        r.setLevel(level);
        r.setHouseDescription(houseDescription);
        r.setPicture(picture);
        r.setVideo(video);
        r.setTitle(title);
        r.setAddress(address);
        return r;
    }
}
