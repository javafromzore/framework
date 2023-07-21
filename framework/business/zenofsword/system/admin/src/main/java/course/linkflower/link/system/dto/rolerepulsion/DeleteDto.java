package course.linkflower.link.system.dto.rolerepulsion;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DeleteDto {
    private List<String> roleIdA;
    private List<String> roleIdB;

    public List<RoleIdDto> toRoleDtos() {
        List<RoleIdDto> roleIdDtos=new ArrayList<>();
        for (int i=0; i<roleIdA.size(); i++){
            RoleIdDto roleIdDto=new RoleIdDto();
            roleIdDto.setRoleIdA(Long.parseLong(roleIdA.get(i)));
            roleIdDto.setRoleIdB(Long.parseLong(roleIdB.get(i)));
            roleIdDtos.add(roleIdDto);
        }
        return roleIdDtos;
    }
}
