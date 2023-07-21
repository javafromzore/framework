package course.linkflower.link.oneframework.house.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("menu")
public class Menu {
    private Long id;
    private String name;
    private Long parentId;
    private int columnType;
    private String barcode;
    private String description;
    private int sortValue;
    private String icon;
    private String code;
    private String url;
}
