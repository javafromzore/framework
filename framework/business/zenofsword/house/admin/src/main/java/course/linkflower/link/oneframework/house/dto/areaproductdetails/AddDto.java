package course.linkflower.link.oneframework.house.dto.areaproductdetails;

import course.linkflower.link.oneframework.house.model.AreaProductDetails;
import lombok.Data;

@Data
public class AddDto {
    private String targetId;
    private String areaInfoId;
    private String targetType;
    private String areaType;
    private int areaLevel;

    public AreaProductDetails toModel(){
        AreaProductDetails areaProductDetails = new AreaProductDetails();
        areaProductDetails.setTargetId(Long.parseLong(targetId));
        areaProductDetails.setAreaInfoId(Long.parseLong(areaInfoId));
        areaProductDetails.setTargetType(targetType);
        areaProductDetails.setAreaType(areaType);
        areaProductDetails.setAreaLevel(areaLevel);
        return  areaProductDetails;
    }
}
