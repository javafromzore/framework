package course.linkflower.link.oneframework.car.dao;

import course.linkflower.link.oneframework.car.dto.dict.SearchDto;
import course.linkflower.link.oneframework.car.vo.dict.DictVo;
import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.oneframework.model.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DictMapper extends SuperMapper<DictMapper> {
    int countTypeKey(@Param("type") String type, @Param("key") String key);

    int add(Dict dict);

    Dict getById(@Param("id") long id);

    int lastOrdering(@Param("type") String type);

    int deleteById(@Param("id") long id);

    int countTypeKeyDiffId(@Param("type") String type, @Param("key") String key, @Param("id") long id);

    int update(Dict dict);

    List<Dict> listByType(@Param("type") String type, @Param("maxCount") int maxCount);

    int countAll(SearchDto searchDto);

    List<DictVo> search(SearchDto searchDto);
}
