package course.linkflower.link.oneframework.house.dto.communityInfo;

import course.linkflower.link.oneframework.house.model.CommunityInfo;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class UpdateDto {
    private String id;
    private String communityId;
    private int buildYears;
    private String name;
    private String propertyCompany;
    private String businessArea;

    public CommunityInfo toModel(){
        CommunityInfo communityInfo = new CommunityInfo();
        if (!StringUtils.isEmpty(id)){
            communityInfo.setId(Long.parseLong(id));
        }
        if (!StringUtils.isEmpty(communityId)){
            communityInfo.setCommunityId(Long.parseLong(communityId));
        }
        communityInfo.setBuildYears(buildYears);
        communityInfo.setName(name);
        communityInfo.setPropertyCompany(propertyCompany);
        communityInfo.setBusinessArea(businessArea);
        return  communityInfo;
    }
}
