package course.linkflower.link.oneframework.car.mapper;

import course.linkflower.link.oneframework.car.dto.carconfig.LocateDto;
import course.linkflower.link.oneframework.car.dto.carconfig.OtherUseDto;
import course.linkflower.link.oneframework.model.CarConfig;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarConfigModelMapper {
    List<CarConfig> otherUseToCarConfig(List<OtherUseDto> otherUseDtos);
    List<CarConfig> locatesToCarConfigs(List<LocateDto> locateDtos);
}
