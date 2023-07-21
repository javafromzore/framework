package course.linkflower.link.oneframework.common.filter.utils;


public class SessionUtil {
    private static final ThreadLocal<Object> tl = new ThreadLocal<>();

    public static void setSession(Object session){
        tl.set(session);
    }
    public static Object getSession(){
        return tl.get();
    }

    public static void removeSession(){
        tl.remove();
    }
}
