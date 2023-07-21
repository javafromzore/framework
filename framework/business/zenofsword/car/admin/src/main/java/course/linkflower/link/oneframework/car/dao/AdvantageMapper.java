package course.linkflower.link.oneframework.car.dao;

import course.linkflower.link.oneframework.car.vo.advantage.AdvantageVo;
import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.oneframework.car.dto.advantage.SearchDto;
import course.linkflower.link.oneframework.car.dto.advantage.UpdateDto;
import course.linkflower.link.oneframework.model.Advantage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdvantageMapper extends SuperMapper<AdvantageMapper> {

    int countConfigId(@Param("configId") String configId);

    int add(Advantage advantage);

    Advantage getById(@Param("id") Long id);

    int deleteById(@Param("id") Long id);

    int update(UpdateDto updateDto);

    int countConfigIdDiffId(@Param("configId") String configId,@Param("id") long id);

    int countAll(SearchDto searchDto);

    List<AdvantageVo> search(SearchDto searchDto);

    int deleteByIds(@Param("ids") List<Long> ids);
}
