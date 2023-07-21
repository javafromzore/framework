package course.linkflower.link.oneframework.house.vo.picture;

import course.linkflower.link.oneframework.house.model.Picture;
import lombok.Data;

@Data
public class PictureVo {
    private String id;
    private String rentHouseInfoId;
    private String type;
    private String name;
    private String url;

    public PictureVo loadFrom(Picture picture){
        if (picture!=null){
            id=String.valueOf(picture.getId());
            rentHouseInfoId = String.valueOf(picture.getRentHouseInfoId());
            type = picture.getType();
            name = picture.getName();
            url = picture.getUrl();
        }
        return this;
    }
}
