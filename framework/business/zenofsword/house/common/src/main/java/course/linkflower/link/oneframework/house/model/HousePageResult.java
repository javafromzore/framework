package course.linkflower.link.oneframework.house.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HousePageResult<T> implements Serializable {
    private static final long serialVersionUID = -275582248840137389L;
    private int total;
    private int page;
    private int pageSize;
    // 总数
    private Long count;
    /**
     * 是否成功：0 成功、1 失败
     */
    private int code;
    /**
     * 当前页结果集
     */
    private List<T> data;
}
