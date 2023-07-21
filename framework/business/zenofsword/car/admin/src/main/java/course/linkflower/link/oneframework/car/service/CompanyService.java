package course.linkflower.link.oneframework.car.service;

import course.linkflower.link.oneframework.car.dto.company.AddDto;
import course.linkflower.link.oneframework.car.dto.company.SearchDto;
import course.linkflower.link.oneframework.car.dto.company.SearchKeyDto;
import course.linkflower.link.oneframework.car.dto.company.UpdateDto;
import course.linkflower.link.oneframework.car.vo.company.CompanyInfoVo;
import course.linkflower.link.oneframework.car.vo.company.CompanyVo;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;

import java.util.List;

public interface CompanyService {

    CompanyVo add(AddDto addDto);

    CompanyVo update(UpdateDto updateDto);

    void delete(IdDto idDto);

    CompanyVo getById(IdDto idDto);

    PageResult search(SearchDto searchDto);

    List<CompanyInfoVo> listInfoBySearchKey(SearchKeyDto searchKeyDto);
}
