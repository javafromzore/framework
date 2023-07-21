package course.linkflower.link.oneframework.car.dto.carconfig;

import lombok.Data;

@Data
public class UpdateDto {
    private String id;
    private String carId;
    private String configId;
    private String value;
    private String valueStr;
}
