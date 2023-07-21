package course.linkflower.link.oneframework.car.dao;

import course.linkflower.link.oneframework.db.mapper.SuperMapper;
import course.linkflower.link.oneframework.model.UsedCar;
import course.linkflower.link.oneframework.car.vo.usedcar.UsedCarVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface UsedCarMapper extends SuperMapper<UsedCarMapper> {

    int add(UsedCar usedCar);

    int update(UsedCar usedCar);

    UsedCarVo getUsedCarById(@Param("id") long id);

    List<UsedCarVo> listUsedCarByPostDate(@Param("postDate") Date postDate,@Param("DefaultMaxCountLimit") int DefaultMaxCountLimit);

    int deleteById(@Param("id") long id);

    List<UsedCarVo> loadPageByPostDateStatus(@Param("startCount") int startCount, @Param("pageSize") int pageSize,
                                             @Param("postDate") Date postDate, @Param("status") Byte status);

    int countAll();

    int deleteByIds(@Param("ids") List<Long> ids);
}
