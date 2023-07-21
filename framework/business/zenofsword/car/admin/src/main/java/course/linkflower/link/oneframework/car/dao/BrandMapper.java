package course.linkflower.link.oneframework.car.dao;

import course.linkflower.link.oneframework.car.dto.brand.SearchDto;
import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.oneframework.model.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrandMapper extends SuperMapper<BrandMapper> {
    int add(Brand brand);

    int deleteById(@Param("id") long id);

    int update(Brand brand);

    Brand getById(@Param("id") long id);

    List<Brand> listByCompanyId(@Param("id") long id, @Param("DefaultMaxCountLimit") int DefaultMaxCountLimit);

    int countName(@Param("name") String name);

    int countNamediffId(@Param("name") String name, @Param("id") long id);

    int countAll(@Param("SearchDto") SearchDto searchDto, @Param("companyIds") List<Long> CompanyIds);


    List<Brand> search(@Param("SearchDto") SearchDto searchDto, @Param("companyIds") List<Long> companyIds);

    int deleteByIds(@Param("ids") List<Long> ids);
}
