package course.linkflower.link.oneframework.house.dto.housedevicetype;

import lombok.Data;

@Data
public class AddMoreDto {
    private Long[] deviceIds;
    private String type;
    private String houseId;
}
