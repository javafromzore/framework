package course.linkflower.link.oneframework.car.dto.carconfig;

import lombok.Data;

import java.util.List;

@Data
public class DeleteByTargetDto {
    private List<LocateDto> locateDtos;
}
