package course.linkflower.link.oneframework.house.vo.communityinfo;

import course.linkflower.link.oneframework.house.model.CommunityInfo;
import lombok.Data;

@Data
public class CommunityInfoVo {
    private String id;
    private String communityId;
    private int buildYears;
    private String name;
    private String propertyCompany;
    private String businessArea;

    public CommunityInfoVo loadFrom(CommunityInfo communityInfo){
        if (communityInfo!=null){
            id = String.valueOf(communityInfo.getId());
            communityId = String.valueOf(communityInfo.getCommunityId());
            buildYears = communityInfo.getBuildYears();
            name = communityInfo.getName();
            propertyCompany = communityInfo.getPropertyCompany();
            businessArea = communityInfo.getBusinessArea();
        }
            return this;
    }
}
