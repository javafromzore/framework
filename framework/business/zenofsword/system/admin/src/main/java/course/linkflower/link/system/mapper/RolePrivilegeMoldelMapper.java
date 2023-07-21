package course.linkflower.link.system.mapper;

import course.linkflower.link.system.dto.role.PriviIdDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolePrivilegeMoldelMapper {

    List<Long> IdsConvertLong(String[] beforPriviIds);
}
