package course.linkflower.link.oneframework.car.dao;

import course.linkflower.link.oneframework.common.dto.PageDto;
import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.oneframework.model.UsedCarPhoto;
import course.linkflower.link.oneframework.car.vo.usedcarphoto.UsedCarPhotoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UsedCarPhotoMapper extends SuperMapper<UsedCarPhotoMapper> {

    int add(UsedCarPhoto usedCarPhoto);

    Integer lastOrdering(@Param("id") long id);

    int deleteById(@Param("id") long id);

    int update(UsedCarPhoto usedCarPhoto);

    List<UsedCarPhoto> listByUsedCarId(@Param("usedCarId") long usedCarId,@Param("maxCount") int maxCount);

    List<UsedCarPhotoVo> search(PageDto pageDto);

    int countAll(PageDto pageDto);

    int deleteByIds(@Param("ids") List<Long> ids);

    UsedCarPhoto getById(Long id);
}
