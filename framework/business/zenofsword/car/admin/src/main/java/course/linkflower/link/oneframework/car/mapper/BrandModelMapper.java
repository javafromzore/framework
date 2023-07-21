package course.linkflower.link.oneframework.car.mapper;

import course.linkflower.link.oneframework.car.vo.brand.BrandVo;
import course.linkflower.link.oneframework.car.dto.brand.AddDto;
import course.linkflower.link.oneframework.car.dto.brand.UpdateDto;
import course.linkflower.link.oneframework.model.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandModelMapper {
    Brand addToBrand(AddDto addDto);

    Brand updateToBrand(UpdateDto updateDto);

    BrandVo brandToVo(Brand brand);

    List<BrandVo> brandsToVos(List<Brand> brands);
}
