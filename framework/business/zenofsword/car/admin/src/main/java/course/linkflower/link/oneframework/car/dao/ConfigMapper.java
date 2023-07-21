package course.linkflower.link.oneframework.car.dao;

import course.linkflower.link.oneframework.car.dto.config.SearchDto;
import course.linkflower.link.oneframework.car.vo.config.ConfigDetailVo;
import course.linkflower.link.oneframework.car.vo.config.ConfigVo;
import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.oneframework.car.dto.carconfig.RelevanceDto;
import course.linkflower.link.oneframework.model.Config;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ConfigMapper extends SuperMapper<ConfigMapper> {
    int add(Config config);

    int deleteByIds(@Param("ids") List<Long> ids);

    int deleteById(@Param("id") long id);

    int update(Config config);

    Config getById(@Param("id") Long id);

    List<ConfigVo> search(SearchDto searchDto);

    int countAll(SearchDto searchDto);

    int countName(@Param("config") String config);

    Integer lastOrdering();

    int countNameDiffId(@Param("config") String config, @Param("id") long id);

    Config getById(@Param("id") long id);

    List<ConfigDetailVo> detail(@Param("relevanceDtos") List<RelevanceDto> relevanceDtos);
}
