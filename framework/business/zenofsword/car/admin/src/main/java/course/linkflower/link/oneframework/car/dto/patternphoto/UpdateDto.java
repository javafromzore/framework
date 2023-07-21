package course.linkflower.link.oneframework.car.dto.patternphoto;

import course.linkflower.link.oneframework.model.PatternPhoto;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class UpdateDto {
    private String id;
    private String patternId;
    private String photo;
    private Integer ordering;

    public PatternPhoto toPatternPhoto() {
        PatternPhoto patternPhoto =new PatternPhoto();
        if (StringUtils.isNotEmpty(id)){
            patternPhoto.setId(Long.valueOf(id));
        }
        if (StringUtils.isNotEmpty(patternId)){
            patternPhoto.setPatternId(Long.valueOf(patternId));
        }
        patternPhoto.setPhoto(photo);
        patternPhoto.setOrdering(ordering);
        return patternPhoto;
    }
}
