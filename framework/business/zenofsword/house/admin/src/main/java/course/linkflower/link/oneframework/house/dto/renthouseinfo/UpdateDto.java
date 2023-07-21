package course.linkflower.link.oneframework.house.dto.renthouseinfo;

import course.linkflower.link.oneframework.house.model.RentHouseInfo;
import lombok.Data;

@Data
public class UpdateDto {
    private String id;
    private String clientId;
    private String agentId;
    private String communityInfoId;
    private String depositTypeId;
    private String commissionId;
    private String rentHouseTypeId;
    private String decorateTypeId;
    private String orientationId;
    private String storeyId;
    private double propertyPrice;
    private double houseSize;
    private int bedroom;
    private int storey;
    private int livingroom;
    private int washroom;
    private int rent;
    private int status;
    private int level;
    private String houseDescription;
    private String picture;
    private String video;
    private String title;
    private String address;

    private String deviceIds;
    public RentHouseInfo toModel(){
        RentHouseInfo r = new RentHouseInfo();
        r.setId(Long.parseLong(id));
        if (clientId!=null){
            r.setClientId(Long.parseLong(clientId));
        }
        if (agentId!=null){
            r.setAgentId(Long.parseLong(agentId));
        }
        if (communityInfoId!=null){
            r.setCommunityInfoId(Long.parseLong(communityInfoId));
        }
        if (decorateTypeId != null){
            r.setDepositTypeId(Long.parseLong(depositTypeId));
        }
        if (commissionId!=null){
            r.setCommissionId(Long.parseLong(commissionId));
        }
        if (rentHouseTypeId!=null){
            r.setRentHouseTypeId(Long.parseLong(rentHouseTypeId));
        }
        if (decorateTypeId!=null){
            r.setDecorateTypeId(Long.parseLong(decorateTypeId));
        }
        if (orientationId!=null){
            r.setOrientationId(Long.parseLong(orientationId));
        }
        if (storeyId != null){
            r.setStoreyId(Long.parseLong(storeyId));
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
