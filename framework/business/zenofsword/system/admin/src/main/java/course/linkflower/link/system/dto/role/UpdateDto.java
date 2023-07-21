package course.linkflower.link.system.dto.role;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UpdateDto {
    private String id;
    private String name;
    private String code;
    private int ordering;
    private List<String> beforPriviIds;
    private List<String> afterPriviIds;
    private Integer countLimit;

    public List<PriviIdDto> toPriviIds() {
        List<PriviIdDto> priviIdDtos=new ArrayList<>();
        for (int i=0; i<afterPriviIds.size(); i++){
            PriviIdDto priviIdDto=new PriviIdDto();
            priviIdDto.setAfterPriviId(Long.parseLong(afterPriviIds.get(i)));
            priviIdDto.setBeforPriviId(Long.parseLong(beforPriviIds.get(i)));
            priviIdDtos.add(priviIdDto);
        }
        return priviIdDtos;
    }
}
