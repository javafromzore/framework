package course.linkflower.link.oneframework.car.vo.company;

import lombok.Data;

import java.util.Map;

@Data
public class CompanyInfoVo {
    private String id;
    private String name;

    public CompanyInfoVo loadFrom(Long id, Map<String, CompanyInfoVo> companyInfoVoMap) {
        this.id=String.valueOf(id);
        if (companyInfoVoMap!=null && companyInfoVoMap.size()>0)
        name=companyInfoVoMap.get(id).getName();
        return this;
    }
}
