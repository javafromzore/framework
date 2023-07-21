package course.linkflower.link.oneframework.house.vo.menu;

import course.linkflower.link.oneframework.house.model.Menu;
import lombok.Data;

@Data

public class MenuVo {
    private String id;
    private String name;
    private String parentId;
    private int columnType;
    private String barcode;
    private String description;
    private int sortValue;
    private String icon;
    private String code;
    private String url;
    public MenuVo loadFrom(Menu m){
        if (m!=null){
            name=m.getName();
            parentId=String.valueOf(m.getParentId());
            columnType = m.getColumnType();
            barcode = m.getBarcode();
            description = m.getDescription();
            sortValue = m.getSortValue();
            icon = m.getIcon();
            code = m.getCode();
            url = m.getUrl();
        }
        return this;
    }
}
