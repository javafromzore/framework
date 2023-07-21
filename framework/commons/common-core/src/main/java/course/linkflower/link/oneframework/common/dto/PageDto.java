package course.linkflower.link.oneframework.common.dto;


import lombok.Data;

@Data
public class PageDto<T> {

    /**
     * 当前页
     */
    private int page = 0;


    /**
     * 页大小
     */
    private int pageSize = 10;


    private int pageStart;
    /**
     * 查询条件
     */
    private T condition;

    public int getPageStart() {
        return (page - 1) * pageSize;
    }
}
