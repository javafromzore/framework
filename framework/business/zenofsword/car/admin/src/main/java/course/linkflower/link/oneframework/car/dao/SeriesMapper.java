package course.linkflower.link.oneframework.car.dao;

import course.linkflower.link.oneframework.car.dto.series.SearchDto;
import course.linkflower.link.oneframework.car.vo.series.SeriesVo;
import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.oneframework.model.Series;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SeriesMapper extends SuperMapper<SeriesMapper> {
    int add(Series series);

    int deleteById(@Param("id") long id);

    int countNameDiffId(@Param("name") String name,@Param("id") long id);
    int countName(@Param("name") String name);


    Series getById(@Param("id") long id);

    int update(Series series);

    int countAll(SearchDto searchDto);

    Integer lastCount(@Param("brandId") long brandId);

    List<SeriesVo> search(SearchDto searchDto);
}
