package course.linkflower.link.oneframework.car.mapper;

import course.linkflower.link.oneframework.car.dto.pattern.AddDto;
import course.linkflower.link.oneframework.car.dto.pattern.UpdateDto;
import course.linkflower.link.oneframework.model.Pattern;
import course.linkflower.link.oneframework.car.vo.config.ConfigDetailVo;
import course.linkflower.link.oneframework.car.vo.pattern.PatternDetailVo;
import course.linkflower.link.oneframework.car.vo.pattern.PatternVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatternModelMapper {
    Pattern addToPattern(AddDto addDto);

    PatternVo patternToVo(Pattern pattern);

    Pattern updateToPattern(UpdateDto updateDto);

    @Mapping(target = "configDetailVos", source = "configDetailVos")
    PatternDetailVo detail(Pattern pattern, List<ConfigDetailVo> configDetailVos);
}
