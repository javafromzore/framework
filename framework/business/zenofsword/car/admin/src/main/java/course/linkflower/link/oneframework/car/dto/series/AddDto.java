package course.linkflower.link.oneframework.car.dto.series;

import course.linkflower.link.oneframework.car.dto.carconfig.OtherUseDto;
import course.linkflower.link.oneframework.model.CarConfig;
import course.linkflower.link.oneframework.model.Series;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class AddDto {
    private String brandId;
    private String name;
    private String ordering;
    private String companyId;
    private OtherUseDto[] otherUseDtos;
    public Series toCarInfor() {
        Series series =new Series();
        if (StringUtils.isNotEmpty(brandId)){
            series.setBrandId(Long.valueOf(brandId));
        }
        series.setName(name);
        if(StringUtils.isNotEmpty(ordering)){
            series.setOrdering(Integer.valueOf(ordering));
        }
        return series;
    }

    public List<CarConfig> toCarConfigs(Long serierId) {
        List<CarConfig> carConfigs =new ArrayList<>();
        for (OtherUseDto otherUseDto : otherUseDtos){
            CarConfig carConfig = otherUseDto.toCarConfig(serierId,CarConfig.TypeSeries);
            carConfigs.add(carConfig);
        }
        return carConfigs;
    }
}
