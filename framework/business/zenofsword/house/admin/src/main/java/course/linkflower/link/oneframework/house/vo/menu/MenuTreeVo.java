package course.linkflower.link.oneframework.house.vo.menu;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
public class MenuTreeVo {

    private String id;
    private String name;
    private String parentId;
    private int columnType;
    private String barcode;
    private String description;
    private int sortValue;
    private String icon;
    private String code;
    private List<MenuTreeVo> childs = new ArrayList<>();

    public static MenuTreeVo loadFromList(List<MenuTreeVo> list) {
        if (list.size() > 0) {
            MenuTreeVo root = list.get(0);
            Map<String, MenuTreeVo> MenuTreeVoMap = new HashMap<>();
            for (MenuTreeVo l : list) {
                MenuTreeVoMap.put(l.getId(), l);
                MenuTreeVo parent = MenuTreeVoMap.get(l.getParentId());
                if (parent != null) {
                    parent.childs.add(l);
                }
            }
            return root;
        }
        return null;
    }
}
