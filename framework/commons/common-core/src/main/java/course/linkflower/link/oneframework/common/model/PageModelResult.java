package course.linkflower.link.oneframework.common.model;

import lombok.Data;

@Data
public class PageModelResult<T> {
    private T data;
    private int total;
    private int pageCount;


}
