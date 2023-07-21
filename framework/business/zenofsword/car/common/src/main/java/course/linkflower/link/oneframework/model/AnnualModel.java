package course.linkflower.link.oneframework.model;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("annual_model")
public class AnnualModel {
    private Long id;
    private Long seriesId;
    private String year;     //年代  if years == null ,  years = name
    private Integer ordering;
}
