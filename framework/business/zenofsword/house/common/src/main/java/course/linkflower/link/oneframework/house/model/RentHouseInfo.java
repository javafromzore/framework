package course.linkflower.link.oneframework.house.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("rent_house_info")
public class RentHouseInfo {
    private Long id;
    private Long clientId;
    private Long agentId;
    private Long communityInfoId;
    private Long depositTypeId;
    private Long commissionId;
    private Long rentHouseTypeId;
    private Long decorateTypeId;
    private Long orientationId;
    private Long bedroomTypeId;
    private Long storeyId;
    private Double propertyPrice;
    private Double houseSize;
    private Integer bedroom;
    private Integer livingroom;
    private Integer washroom;
    private Integer rent;
    private Integer status;
    private Integer level;
    private Integer storey;
    private String houseDescription;
    private String picture;
    private String video;
    private String title;
    private String address;
}
