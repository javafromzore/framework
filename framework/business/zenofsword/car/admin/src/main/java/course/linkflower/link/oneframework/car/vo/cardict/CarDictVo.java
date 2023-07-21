package course.linkflower.link.oneframework.car.vo.cardict;

import course.linkflower.link.oneframework.model.CarDict;
import lombok.Data;

@Data
public class CarDictVo {
    private String id;
    private String value;
    private String key;
    private String type;
    private Integer ordering;

    public CarDictVo loadFrom(CarDict carDict) {
        if (carDict !=null){
            if (carDict.getId()!=null) {
                id = String.valueOf(carDict.getId());
            }
            if (carDict.getValue() != null) {
                value=String.valueOf(carDict.getValue());
            }
            key= carDict.getKey();
            type= carDict.getType();
            if (carDict.getOrdering()!=null){
                ordering=carDict.getOrdering();
            }
        }
        return this;
    }
}
