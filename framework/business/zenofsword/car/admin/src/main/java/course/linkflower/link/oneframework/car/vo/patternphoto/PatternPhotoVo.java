package course.linkflower.link.oneframework.car.vo.patternphoto;

import course.linkflower.link.oneframework.model.PatternPhoto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PatternPhotoVo {
    private String id;
    private String patternId;
    private String photo;
    private Integer ordering;

    public PatternPhotoVo loadFrom(PatternPhoto patternPhoto) {
        if (patternPhoto != null) {
            if (patternPhoto.getId() != null) {
                id=String.valueOf(patternPhoto.getId());
            }
            if (patternPhoto.getPatternId() != null) {
                patternId=String.valueOf(patternPhoto.getPatternId());
            }
            photo=patternPhoto.getPhoto();
            ordering=patternPhoto.getOrdering();
        }
        return this;
    }

    public static List<PatternPhotoVo> loadFromList(List<PatternPhoto> patternPhotos){
        List<PatternPhotoVo> patternPhotoVos=new ArrayList<>();
        for (PatternPhoto patternPhoto:patternPhotos){
            patternPhotoVos.add(new PatternPhotoVo().loadFrom(patternPhoto));
        }
        return patternPhotoVos;
    }
}
