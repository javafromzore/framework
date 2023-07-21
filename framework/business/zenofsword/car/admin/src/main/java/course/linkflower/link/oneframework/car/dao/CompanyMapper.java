package course.linkflower.link.oneframework.car.dao;

import course.linkflower.link.oneframework.car.dto.company.SearchDto;
import course.linkflower.link.oneframework.car.vo.company.CompanyInfoVo;
import course.linkflower.link.oneframework.car.vo.company.CompanyVo;
import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.oneframework.model.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CompanyMapper extends SuperMapper<CompanyMapper> {
    int add(Company company);

    int update(Company company);

    Company getById(@Param("id") long id);

    int countName(@Param("name")String name);

    int countNameDiffId(@Param("name") String name,@Param("id") long id);

    List<CompanyVo> search(SearchDto searchDto);

    int countAll(SearchDto searchDto);

    List<CompanyInfoVo> listInfoBySearchKey(@Param("searchKey") String searchKey, @Param("ShowMaxCount") int ShowMaxCount);

    List<Long> listIdBySearchKey(@Param("searchKey") String searchKey);

    int deleteByIds(@Param("ids") List<Long> ids);

    List<CompanyInfoVo> listInfoByIds(@Param("ids") List<Long> ids);
}
