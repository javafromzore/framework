package course.linkflower.link.oneframework.car.vo.dict;

import course.linkflower.link.oneframework.model.Dict;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DictVo {
    private String id;
    private String value;
    private String key;
    private String type;
    private Integer ordering;

    public static List<DictVo> loadFromList(List<Dict> dicts) {
        List<DictVo> dictVos=new ArrayList<>();
        for (Dict dict:dicts){
            dictVos.add(new DictVo().loadFrom(dict));
        }
        return dictVos;
    }

    public DictVo loadFrom(Dict dict) {
        if (dict != null) {
            if (dict.getId()!=null) {
                id = String.valueOf(dict.getId());
            }
            value=dict.getValue();
            key=dict.getKey();
            type=dict.getType();
            ordering=dict.getOrdering();
        }
        return this;
    }
}
