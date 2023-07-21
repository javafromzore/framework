package course.linkflower.link.oneframework.car.dao;

import course.linkflower.link.oneframework.car.vo.pattern.PatternVo;
import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.oneframework.car.dto.pattern.SearchDto;
import course.linkflower.link.oneframework.model.Pattern;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PatternMapper extends SuperMapper<PatternMapper> {

    int countNameAnnualId(@Param("name") String name,@Param("annualId") long annualId);

    int add(Pattern pattern);

    int deleteById(@Param("id") long id);

    int countNameAnnualIdDiffId(@Param("name") String name,@Param("annualId") long annualId, @Param("id") long id);

    int update(Pattern pattern);

    Pattern getById(@Param("id") long id);

    List<PatternVo> search(SearchDto searchDto);

    int countAll(SearchDto searchDto);

    int deletByIds(@Param("ids") List<Long> ids);

    Integer lastCount();
}
