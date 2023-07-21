package course.linkflower.link.system.mapper;

import course.linkflower.link.system.dto.privilege.AddDto;
import course.linkflower.link.system.dto.privilege.UpdateDto;
import course.linkflower.link.system.model.Privilege;
import course.linkflower.link.system.vo.privilege.PrivilegeVo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrivilegeModelMapper {

    Privilege addToPrivi(AddDto addDto);

    PrivilegeVo priviToVo(Privilege privi);

    List<Long> IdsConvertLong(String[] ids);

    Privilege updateToPrivi(UpdateDto updateDto);

    List<Long> IdsToLong(String[] priviIds);
}
