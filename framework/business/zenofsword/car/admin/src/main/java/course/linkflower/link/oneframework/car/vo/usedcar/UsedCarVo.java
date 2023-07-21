package course.linkflower.link.oneframework.car.vo.usedcar;

import course.linkflower.link.oneframework.model.UsedCar;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
public class UsedCarVo {
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
    public UsedCarVo loadFrom(UsedCar usedCar) {
        Long aLong=usedCar.getId();
        if (Objects.nonNull(aLong)){
            id=String.valueOf(aLong);
        }
        Long aLong1=usedCar.getCarInforId();
        if (Objects.nonNull(aLong1)){
            carInforId=String.valueOf(aLong1);
        }
        Long aLong2=usedCar.getAccountId();
        if (Objects.nonNull(aLong2)) {
            accountId=String.valueOf(aLong2);
        }
        postDate=usedCar.getPostDate();
        Long aLong3=usedCar.getBuildingId();
        if (Objects.nonNull(aLong3)){
            buildingId=String.valueOf(aLong3);
        }
        licenseDate=usedCar.getLicenseDate();
        contactedName=usedCar.getContactedName();
        status=usedCar.getStatus();
        photoCount=usedCar.getPhotoCount();
        natureKey=usedCar.getNatureKey();
        insuranceDate=usedCar.getInsuranceDate();
        aunnualInspectionDate=usedCar.getAunnualInspectionDate();
        maintenanceKey=usedCar.getMaintenanceKey();
        compulsoryInsuranceDate=usedCar.getCompulsoryInsuranceDate();
        vin=usedCar.getVin();
        description=usedCar.getDescription();
        transferFeeKey=usedCar.getTransferFeeKey();
        anxuanKey=usedCar.getAnxuanKey();
        Long aLong4=usedCar.getPrice();
        if (Objects.nonNull(aLong4)){
            price=String.valueOf(aLong4);
        }
        Long aLong5=usedCar.getMileage();
        if (Objects.nonNull(aLong5)){
            mileage=String.valueOf(aLong5);
        }
        return this;
    }
}
