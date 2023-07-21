package course.linkflower.link.oneframework.car.vo.usedcarphoto;

import course.linkflower.link.oneframework.model.UsedCarPhoto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UsedCarPhotoVo {
    private String id;
    private String usedCarId;
    private String photo;
    private Integer ordering;
    public UsedCarPhotoVo loadFrom(UsedCarPhoto usedCarPhoto) {
        if (usedCarPhoto!=null) {
            if (usedCarPhoto.getId() != null) {
                id = String.valueOf(usedCarPhoto.getId());
            }
            if (usedCarPhoto.getUsedCarId() != null) {
                usedCarId = String.valueOf(usedCarPhoto.getUsedCarId());
            }
            photo = usedCarPhoto.getPhoto();
            ordering = usedCarPhoto.getOrdering();
        }
            return this;
    }

    public static List<UsedCarPhotoVo> loadFromList(List<UsedCarPhoto> usedCarPhotos) {
        List<UsedCarPhotoVo> usedCarPhotoVos=new ArrayList<>();
        for (UsedCarPhoto usedCarPhoto:usedCarPhotos){
            usedCarPhotoVos.add(new UsedCarPhotoVo().loadFrom(usedCarPhoto));
        }
        return usedCarPhotoVos;
    }
}
