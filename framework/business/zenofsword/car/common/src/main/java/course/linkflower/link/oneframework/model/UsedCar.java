package course.linkflower.link.oneframework.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("used_car")
public class UsedCar {
    private Long id;
    private Long carInforId;        //花冠, 80%
    private Long carPatternId;      //2010  20%
    private Long accountId;
    private Date postDate;
    private Long buildingId;
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
    private Long price;
    private Long mileage;
}
