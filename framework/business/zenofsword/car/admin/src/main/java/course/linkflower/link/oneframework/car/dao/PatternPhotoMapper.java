package course.linkflower.link.oneframework.car.dao;

import course.linkflower.link.oneframework.car.vo.patternphoto.PatternPhotoVo;
import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.oneframework.car.dto.patternphoto.SearchDto;
import course.linkflower.link.oneframework.model.PatternPhoto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PatternPhotoMapper extends SuperMapper<PatternPhotoMapper> {

    int add(PatternPhoto patternPhoto);

    Integer lastOrdering(@Param("patternId") long patternId);

    int deleteById(@Param("id") long id);


    int update(PatternPhoto patternPhoto);

    List<PatternPhoto> listByPatternId(@Param("patternId") long patternId);

    PatternPhoto getById(@Param("id") long id);

    int countAll(SearchDto searchDto);

    List<PatternPhotoVo> search(SearchDto searchDto);

    int deleteByIds(@Param("ids") List<Long> ids);
}
