package course.linkflower.link.oneframework.car.vo.company;

import course.linkflower.link.oneframework.model.Company;
import lombok.Data;

@Data
public class CompanyVo {
    private String id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String icon;
    public CompanyVo loadFrom(Company company) {
        if (company!=null) {
            if (company.getId() != null) {
                id = String.valueOf(company.getId());
            }
            name = company.getName();
            address = company.getAddress();
            email = company.getEmail();
            phone = company.getPhone();
            icon = company.getIcon();
        }
        return this;
    }
}
