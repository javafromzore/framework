package course.linkflower.link.oneframework.house.vo.areaproductdetails;

import course.linkflower.link.oneframework.house.model.AreaProductDetails;
import lombok.Data;

@Data
public class AreaProductDetailsVo {
    private String id;
    private String targetId;
    private String areaInfoId;
    private String targetType;
    private String areaType;
    private int areaLevel;

    public AreaProductDetailsVo loadFrom(AreaProductDetails areaProductDetails){
        if (areaProductDetails!=null){
            id=String.valueOf(areaProductDetails.getId());
            targetId = String.valueOf(areaProductDetails.getTargetId());
            areaInfoId = String.valueOf(areaProductDetails.getAreaInfoId());
            targetType = areaProductDetails.getTargetType();
            areaType = areaProductDetails.getAreaType();
            areaLevel = areaProductDetails.getAreaLevel();
        }
        return this;
    }
}
