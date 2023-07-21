package course.linkflower.link.oneframework.house.dto.picture;

import course.linkflower.link.oneframework.house.model.Picture;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class UpdateDto {
    private String id;
    private String rentHouseInfoId;
    private String type;
    private String name;
    private String url;

    public Picture toModel(){
        Picture picture = new Picture();
        picture.setId(Long.parseLong(id));
        if (!StringUtils.isEmpty(rentHouseInfoId)){
            picture.setRentHouseInfoId(Long.parseLong(rentHouseInfoId));
        }
        picture.setType(type);
        picture.setName(name);
        picture.setUrl(url);
    return picture;
    }
}
