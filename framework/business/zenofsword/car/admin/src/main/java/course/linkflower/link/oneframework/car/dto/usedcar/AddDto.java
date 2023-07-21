package course.linkflower.link.oneframework.car.dto.usedcar;

import course.linkflower.link.oneframework.model.UsedCar;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

@Data
public class AddDto {
    private Date postDate;
    private String buildingId;
    private byte status;
    private byte photoCount;
    private String natureKey;
    private String vin;
    private String description;
    private String transferFeeKey;
    private String anxuanKey;
    private String carInforId;
    private String price;
    private HistoryInfoDto historyInfoDto;
    private PosterInfoDto posterInfoDto;


    private String[] configIds;

    public UsedCar toModel() {
        UsedCar usedCar=new UsedCar();
        usedCar.setPostDate(postDate);
        if (StringUtils.isNotEmpty(buildingId)){
            usedCar.setBuildingId(Long.valueOf(buildingId));
        }
        usedCar.setStatus(status);
        usedCar.setPhotoCount(photoCount);
        usedCar.setNatureKey(natureKey);
        usedCar.setVin(vin);
        usedCar.setDescription(description);
        usedCar.setTransferFeeKey(transferFeeKey);
        usedCar.setAnxuanKey(anxuanKey);
        usedCar.setLicenseDate(historyInfoDto.getLicneseDate());
        usedCar.setInsuranceDate(historyInfoDto.getInsuranceDate());
        usedCar.setAunnualInspectionDate(historyInfoDto.getAnnualInspection());
        usedCar.setMaintenanceKey(historyInfoDto.getMaintenanceKey());
        usedCar.setCompulsoryInsuranceDate(historyInfoDto.getCompulsoryInsuranceDate());
        if (StringUtils.isNotEmpty(historyInfoDto.getMileage())) {
            usedCar.setMileage(Long.parseLong(historyInfoDto.getMileage()));
        }
        if (StringUtils.isNotEmpty(posterInfoDto.getAccountId())){
            usedCar.setAccountId(Long.parseLong(posterInfoDto.getAccountId()));
        }
        usedCar.setContactedName(posterInfoDto.getContactedName());
        usedCar.setContactedPhone(posterInfoDto.getContactedPhone());
        return null;
    }
}
