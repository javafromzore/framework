package course.linkflower.link.oneframework.car.dto.usedcarphoto;

import course.linkflower.link.oneframework.model.UsedCarPhoto;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class AddDto {
    private String usedCarId;
    private String photo;
    private Integer ordering;

    public UsedCarPhoto toModel(AddDto addDto) {
        UsedCarPhoto usedCarPhoto=new UsedCarPhoto();
        if (StringUtils.isNotEmpty(usedCarId)){
            usedCarPhoto.setUsedCarId(Long.valueOf(usedCarId));
        }
        usedCarPhoto.setPhoto(photo);
        usedCarPhoto.setOrdering(ordering);
        return usedCarPhoto;
    }
}
