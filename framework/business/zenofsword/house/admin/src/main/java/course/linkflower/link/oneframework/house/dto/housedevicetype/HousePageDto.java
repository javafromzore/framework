package course.linkflower.link.oneframework.house.dto.housedevicetype;

import lombok.Data;

@Data
public class HousePageDto<T> {
    /**
     * 当前页
     */
    private int page = 1;
    /**
     * 页大小
     */
    private int pageSize = 10;

    private int pageStart;
    /**
     * 查询条件
     */
    private T condition;

    private String searchKey;
    private String type;

    public int getPageStart() {
        return (page - 1) * pageSize;
    }
}
