package course.linkflower.link.oneframework.car.vo.annualmodel;

import course.linkflower.link.oneframework.model.AnnualModel;
import lombok.Data;

@Data
public class AnnualModelVo {
    private String id;
    private String seriesId;
    private String year;
    private Integer ordering;

    public AnnualModelVo loadFrom(AnnualModel annualModel) {
        if (annualModel != null) {
            if (annualModel.getId() != null) {
                id = String.valueOf(annualModel.getId());
            }
            if (annualModel.getSeriesId() != null) {
                seriesId = String.valueOf(annualModel.getSeriesId());
            }
            year = annualModel.getYear();
            ordering = annualModel.getOrdering();
        }
        return this;
    }
}
