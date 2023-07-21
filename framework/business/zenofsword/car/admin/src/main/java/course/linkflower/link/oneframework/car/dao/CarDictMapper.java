package course.linkflower.link.oneframework.car.dao;

import course.linkflower.link.oneframework.car.dto.cardict.SearchDto;
import course.linkflower.link.oneframework.car.vo.cardict.CarDictInfoVo;
import course.linkflower.link.oneframework.car.vo.cardict.SearchVo;
import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.oneframework.model.CarDict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarDictMapper extends SuperMapper<CarDictMapper> {

    int countTypeKey(@Param("type") String type, @Param("key") String key);

    int add(CarDict carDict);

    CarDict getById(@Param("id") Long id);

    Integer lastOrdering(@Param("type") String type);

    int deleteById(@Param("id") long id);

    int countTypeKeyDiffId(@Param("type") String type, @Param("key") String key, @Param("id") long id);

    int update(CarDict carDict);

    List<SearchVo> search(SearchDto searchDto);

    int countAll(SearchDto searchDto);

    List<CarDictInfoVo> listInfoByType(@Param("type") String type, @Param("showLimit") int showLimit);

    int deleteByIds(@Param("ids") List<Long> ids);
}
