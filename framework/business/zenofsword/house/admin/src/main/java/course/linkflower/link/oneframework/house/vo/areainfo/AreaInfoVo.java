package course.linkflower.link.oneframework.house.vo.areainfo;

import course.linkflower.link.oneframework.house.model.AreaInfo;
import lombok.Data;


@Data
public class AreaInfoVo {
    private String  id;
    private String parentId;
    private int level;
    private String name;
    private String code;
    private String type;
    private String address;

    public AreaInfoVo loadFrom(AreaInfo areaInfo){
        if (areaInfo != null){
            id = String.valueOf(areaInfo.getId());
            parentId = String.valueOf(areaInfo.getParentId());
            level = areaInfo.getLevel();
            name = areaInfo.getName();
            code = areaInfo.getCode();
            type = areaInfo.getType();
            address = areaInfo.getAddress();
        }
        return this;
    }
}
