package course.linkflower.link.oneframework.house.dto.members;


import lombok.Data;

@Data
public class ListDto {
    private String searchKey;   //tel, mail, username   //milk999@sina.com
    private Integer searchByStatus; // buid-in, class vlaue, class = nil    //nil
//    private int searchByStatus; // None： 0, ok，1, disable， 2, 不搜索 //0

    private int sortByName; // 0, 1, 升， 2， 降序   //0
    private int sortByDate; // nil, date        //0
    private int sortByStatus; // statis     //8
}
