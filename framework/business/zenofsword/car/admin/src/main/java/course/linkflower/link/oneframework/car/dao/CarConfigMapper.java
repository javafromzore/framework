package course.linkflower.link.oneframework.car.dao;

import course.linkflower.link.oneframework.car.vo.carconfig.CarConfigVo;
import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.oneframework.car.dto.carconfig.SearchDto;
import course.linkflower.link.oneframework.model.CarConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarConfigMapper extends SuperMapper<CarConfigMapper> {
    int add(CarConfig carConfig);

    int deleteByIds(@Param("ids") List<Long> ids);

    int deleteById(@Param("id") long id);

    int update(CarConfig carConfig);

    CarConfig getById(@Param("id") Long id);

    List<CarConfigVo> search(SearchDto searchDto);

    int countAll(SearchDto searchDto);

    int saves(@Param("carConfigs") List<CarConfig> carConfigs, @Param("type") String type, @Param("targetId") long targetId);

    int updates(@Param("carConfigs") List<CarConfig> carConfigs, @Param("type") String type, @Param("targetId") long targetId);

    int deleteByTarget(@Param("carConfigs") List<CarConfig> carConfigs);
}
