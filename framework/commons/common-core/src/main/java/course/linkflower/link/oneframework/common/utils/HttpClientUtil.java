package course.linkflower.link.oneframework.common.utils;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Map;

@Slf4j
public class HttpClientUtil {

  private static final OkHttpClient client =new OkHttpClient();





    public static String get(String url){
        Request request =new Request.Builder().url(url).get().build();
        Response response=null;
        String result=null;
        try {
            response = client.newCall(request).execute();
            ResponseBody body = response.body();
            result=body.string();
            if (StringUtils.isEmpty(result)){
                log.error("remote access error url={}",url);
            }
        } catch (IOException e) {
            log.error("remote access error url={}",url);
            throw new RuntimeException(e);
        }finally {
            response.close();
        }
        return result;
    }


    public static String getByBody(String url){
        Request request =new Request.Builder().url(url).get().build();
        Response response=null;
        String result=null;
        try {
            response = client.newCall(request).execute();
            ResponseBody body = response.body();
            result=body.string();
            response.close();
        } catch (IOException e) {
            log.error("remote access error url={}",url);
            throw new RuntimeException(e);
        }finally {
            response.close();
        }
        return result;

    }

    public static String get(String url, Map<String,String> headerParam) {
        Request request = new Request.Builder().url(url).headers(Headers.of(headerParam)).get().build();
        Response response = null;
        String result = null;
        try {
            response = client.newCall(request).execute();
            ResponseBody body = response.body();
            result = body.string();
        } catch (IOException e) {
            log.error("remote access error url={}",url);
            throw new RuntimeException(e);
        } finally {
            response.close();
        }
        return result;

    }


}
