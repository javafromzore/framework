package course.linkflower.link.oneframework.car.dto.company;

import lombok.Data;

@Data
public class SearchKeyDto {
    private String searchKey;
    public final static int ShowMaxCount = 100;
}
