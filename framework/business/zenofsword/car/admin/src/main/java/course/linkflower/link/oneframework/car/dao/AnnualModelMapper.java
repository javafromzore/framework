package course.linkflower.link.oneframework.car.dao;

import course.linkflower.link.oneframework.car.vo.annualmodel.AnnualModelVo;
import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.oneframework.car.dto.annualmodel.SearchDto;
import course.linkflower.link.oneframework.model.AnnualModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AnnualModelMapper extends SuperMapper<AnnualModelMapper> {
    int add(AnnualModel annualModel);

    AnnualModel getById(@Param("id") long id);

    int deleteByIds(@Param("ids") List<Long> ids);

    int deleteById(@Param("id") long id);

    int update(AnnualModel annualModel);

    List<AnnualModelVo> search(SearchDto searchDto);

    int countAll(SearchDto searchDto);

    int countSeriesIdYear(@Param("seriesId") long seriesId, @Param("year") String year);

    Integer lastOrdering();

    int countSeriesIdYearDiffId(@Param("seriesId") long seriesId, @Param("year") String year, @Param("id") long id);
}
