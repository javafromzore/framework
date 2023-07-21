package course.linkflower.link.oneframework.car.vo.brand;

import course.linkflower.link.oneframework.model.Brand;
import course.linkflower.link.oneframework.car.vo.company.CompanyInfoVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class SearchVo {
    private String id;
    private String icon;
    private String name;
    private CompanyInfoVo companyInfoVo;

    public static List<SearchVo> loadFromList(List<Brand> brands, Map<String , CompanyInfoVo> companyInfoVoMap) {
        List<SearchVo> searchVos=new ArrayList<>();
        for (Brand brand:brands){
            searchVos.add(new SearchVo().loadFrom(brand,companyInfoVoMap));
        }
        return searchVos;
    }

    private SearchVo loadFrom(Brand brand, Map<String , CompanyInfoVo> companyInfoVoMap) {
        id=String.valueOf(brand.getId());
        icon=brand.getIcon();
        name=brand.getName();
        companyInfoVo=new CompanyInfoVo().loadFrom(brand.getId(),companyInfoVoMap);
        return this;
    }
}
