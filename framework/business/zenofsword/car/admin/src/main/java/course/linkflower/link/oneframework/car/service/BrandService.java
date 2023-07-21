package course.linkflower.link.oneframework.car.service;

import course.linkflower.link.oneframework.car.dto.brand.AddDto;
import course.linkflower.link.oneframework.car.dto.brand.SearchDto;
import course.linkflower.link.oneframework.car.dto.brand.UpdateDto;
import course.linkflower.link.oneframework.car.vo.brand.BrandVo;
import course.linkflower.link.oneframework.car.vo.brand.SearchVo;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;

import java.util.List;

public interface BrandService {
   BrandVo add(AddDto addDto);

    void delete(IdDto idDto);

   BrandVo update(UpdateDto updateDto);

   BrandVo getById(IdDto idDto);
    
    PageResult<SearchVo> search(SearchDto searchDto);

   List<BrandVo>listByCompanyId(IdDto idDto);
}
