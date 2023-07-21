package course.linkflower.link.oneframework.car.dto.usedcar;

import course.linkflower.link.oneframework.model.UsedCar;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

@Data
public class UsedCarDto {
    private String id;
    private String carInforId;
    private String accountId;
    private Date postDate;
    private String buildingId;
    private Date licenseDate;
    private String contactedName;
    private String contactedPhone;
    private byte status;
    private byte photoCount;
    private String natureKey;
    private Date insuranceDate;
    private Date aunnualInspectionDate;
    private String maintenanceKey;
    private Date compulsoryInsuranceDate;
    private String vin;
    private String description;
    private String transferFeeKey;
    private String anxuanKey;
    private String price;
    private String mileage;

    public UsedCar toModel() {
        UsedCar usedCar=new UsedCar();
        if (StringUtils.isNotEmpty(carInforId)){
            usedCar.setCarInforId(Long.valueOf(carInforId));
        }
        if (StringUtils.isNotEmpty(accountId)){
            usedCar.setAccountId(Long.valueOf(accountId));
        }
        usedCar.setPostDate(postDate);
        if (StringUtils.isNotEmpty(buildingId)){
            usedCar.setBuildingId(Long.valueOf(buildingId));
        }
        usedCar.setLicenseDate(licenseDate);
        usedCar.setContactedName(contactedName);
        usedCar.setContactedPhone(contactedPhone);
        usedCar.setStatus(status);
        usedCar.setPhotoCount(photoCount);
        usedCar.setNatureKey(natureKey);
        usedCar.setInsuranceDate(insuranceDate);
        usedCar.setAunnualInspectionDate(insuranceDate);
        usedCar.setMaintenanceKey(maintenanceKey);
        usedCar.setCompulsoryInsuranceDate(compulsoryInsuranceDate);
        usedCar.setVin(vin);
        usedCar.setDescription(description);
        usedCar.setTransferFeeKey(transferFeeKey);
        usedCar.setAnxuanKey(anxuanKey);
        if (StringUtils.isNotEmpty(price)){
            usedCar.setPrice(Long.valueOf(price));
        }
        if (StringUtils.isNotEmpty(mileage)){
            usedCar.setMileage(Long.valueOf(mileage));
        }
        if (StringUtils.isNotEmpty(id)){
            usedCar.setId(Long.valueOf(id));
        }
        return usedCar;
    }
}
