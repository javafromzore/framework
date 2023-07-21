package course.linkflower.link.oneframework.car.mapper;

import course.linkflower.link.oneframework.car.dto.company.AddDto;
import course.linkflower.link.oneframework.car.dto.company.UpdateDto;
import course.linkflower.link.oneframework.model.Company;
import course.linkflower.link.oneframework.car.vo.company.CompanyVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyModelMapper {
    Company addToCompany(AddDto addDto);

    Company updateToCompany(UpdateDto updateDto);

    CompanyVo companyToVo(Company company);
}
