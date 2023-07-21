package course.linkflower.link.oneframework.house.vo.housedictionary;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.model.HouseDictionary;
import course.linkflower.link.oneframework.house.model.RentHouseInfo;
import lombok.Data;

import java.util.List;

@Data
public class HouseDictionaryVo {
    private String id;
    private String type;
    private String key;
    private String value;
    private int sortValue;
    public HouseDictionaryVo loadFrom(HouseDictionary d){
        if (d!=null){
            id =String.valueOf(d.getId());
            type = d.getType();
            key = d.getKey();
            value = d.getValue();
            sortValue = d.getSortValue();
        }
        return this;
    }
    public HouseDictionaryVo getId(long dictionaryId){
        id = String.valueOf(dictionaryId);
        return this;
    }

    public  RentHouseInfo saveIds(List<HouseDictionary> houseDictionaries){
        RentHouseInfo rentHouseInfo = new RentHouseInfo();
        for (HouseDictionary h : houseDictionaries){
            if (h.getType()=="depositType"){
                rentHouseInfo.setDepositTypeId(h.getId());
            }
            if (h.getType()=="renthouseType"){
                rentHouseInfo.setRentHouseTypeId(h.getId());
            }
            if (h.getType()=="decorateType"){
                rentHouseInfo.setDecorateTypeId(h.getId());
            }
            if (h.getType()=="orientation"){
                rentHouseInfo.setOrientationId(h.getId());
            }
            if (h.getType()=="storeyType"){
                rentHouseInfo.setStoreyId(h.getId());
            }
            if (h.getType()=="bedroomType"){
                rentHouseInfo.setStoreyId(h.getId());
            }
        }
        return rentHouseInfo;
    }
}
