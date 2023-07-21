package course.linkflower.link.oneframework.house.dto.commission;

import course.linkflower.link.oneframework.house.model.Commission;
import lombok.Data;

@Data
public class AddDto {
    private String type;
    private String value;

    public Commission toModel(){
        Commission commission = new Commission();
        commission.setType(type);
        commission.setValue(value);
        return commission;
    }
}
