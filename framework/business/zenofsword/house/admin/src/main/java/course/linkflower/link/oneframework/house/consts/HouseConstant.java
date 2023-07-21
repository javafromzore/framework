package course.linkflower.link.oneframework.house.consts;

public class HouseConstant {
    public static  int indexNum = 0;
    public static final String targetType="rentHouse";
    public static Long[] stringToLong(String[] str){
        Long[] arr = new Long[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Long.parseLong(str[i]);
        }
        return arr;
    }
}
