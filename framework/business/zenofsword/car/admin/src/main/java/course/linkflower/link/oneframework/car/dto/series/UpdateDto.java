package course.linkflower.link.oneframework.car.dto.series;

import course.linkflower.link.oneframework.car.dto.carconfig.OtherUseDto;
import course.linkflower.link.oneframework.model.CarConfig;
import course.linkflower.link.oneframework.model.Series;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class UpdateDto {
    private String id;
    private String name;
    private Integer ordering;
    private String companyId;
    private OtherUseDto[] otherUseDtos;

    public Series toSeries() {
        Series series =new Series();
        if(StringUtils.isNotEmpty(id)){
            series.setId(Long.valueOf(id));
        }
        series.setName(name);
        series.setOrdering(ordering);
        if (StringUtils.isNotEmpty(companyId)){
            series.setCompanyId(Long.valueOf(companyId));
        }
        return series;
    }

    public List<CarConfig> toCarConfigs() {
        List<CarConfig> carConfigs=new ArrayList<>();
        for (OtherUseDto otherUseDto : otherUseDtos){
            carConfigs.add(otherUseDto.toCarConfig(Long.parseLong(id), CarConfig.TypeSeries));
        }
        return carConfigs;
    }
}
