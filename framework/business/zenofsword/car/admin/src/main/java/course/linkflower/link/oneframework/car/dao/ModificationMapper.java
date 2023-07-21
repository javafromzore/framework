package course.linkflower.link.oneframework.car.dao;

import course.linkflower.link.oneframework.car.vo.modification.ModificationVo;
import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.oneframework.car.dto.modification.SearchDto;
import course.linkflower.link.oneframework.model.Modification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ModificationMapper extends SuperMapper<UsedCarMapper> {
    int add(Modification modification);

    Modification getById(@Param("id") Long id);

    List<ModificationVo> search(SearchDto searchDto);

    int countAll(SearchDto searchDto);

    int update(Modification modification);

    int deleteByIds(@Param("ids") List<Long> ids);

    int deleteById(@Param("id") Long id);
}
