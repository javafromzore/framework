package course.linkflower.link.oneframework.car.dto.usedcar;

import lombok.Data;

import java.util.Date;

@Data
public class HistoryInfoDto {
    private Date licneseDate;
    private Date insuranceDate;
    private Date annualInspection;
    private String maintenanceKey;
    private Date compulsoryInsuranceDate;
    private String mileage;
}
