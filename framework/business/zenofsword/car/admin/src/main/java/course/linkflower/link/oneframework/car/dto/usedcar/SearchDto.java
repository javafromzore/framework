package course.linkflower.link.oneframework.car.dto.usedcar;

import course.linkflower.link.oneframework.common.dto.PageDto;
import lombok.Data;

import java.util.Date;

@Data
public class SearchDto extends PageDto {
    private Date postDate;
    private Byte status;
}
