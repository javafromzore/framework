package course.linkflower.link.oneframework.car.dto.annualmodel;

import course.linkflower.link.oneframework.model.AnnualModel;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class UpdateDto {
    private String id;
    private String seriesId;
    private String year;
    private Integer ordering;

    public AnnualModel toCarVersion() {
        AnnualModel annualModel = new AnnualModel();
        if (StringUtils.isNotEmpty(id)) {
            annualModel.setId(Long.parseLong(id));
        }
        if (StringUtils.isNotEmpty(seriesId)) {
            annualModel.setSeriesId(Long.parseLong(seriesId));
        }
        annualModel.setYear(year);
        annualModel.setOrdering(ordering);
        return annualModel;
    }
}
