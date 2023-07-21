package course.linkflower.link.oneframework.house.dao;

import course.linkflower.link.oneframework.house.model.Commission;
import course.linkflower.link.oneframework.house.model.CommunityInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CommunityInfoMapper {
    int save (CommunityInfo communityInfo);
    int delete(@Param("id") long id);
    int update(CommunityInfo communityInfo);
    CommunityInfo getById(@Param("id") long id);
}
