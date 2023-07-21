package course.linkflower.link.oneframework.house.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("community_info")
public class CommunityInfo {
    private Long id;
    private Long communityId;
    private int buildYears;
    private String name;
    private String propertyCompany;
    private String businessArea;
}
