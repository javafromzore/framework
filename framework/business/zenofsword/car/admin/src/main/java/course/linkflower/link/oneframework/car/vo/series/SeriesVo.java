package course.linkflower.link.oneframework.car.vo.series;

import course.linkflower.link.oneframework.model.Series;
import lombok.Data;

@Data
public class SeriesVo {
    private String id;
    private String companyId;
    private String name;
    private String brandId;
    private Integer ordering;

    public SeriesVo loadFrom(Series series) {
        if (series !=null) {
            if (series.getId() != null) {
                id = String.valueOf(series.getId());
            }
            if (series.getCompanyId() != null) {
                companyId = String.valueOf(series.getCompanyId());
            }
            name = series.getName();
            if (series.getBrandId() != null) {
                brandId = String.valueOf(series.getBrandId());
            }
            ordering = series.getOrdering();
        }
        return this;
    }
}
