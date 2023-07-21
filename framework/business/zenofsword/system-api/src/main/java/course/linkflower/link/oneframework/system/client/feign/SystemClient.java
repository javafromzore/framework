package course.linkflower.link.oneframework.system.client.feign;

import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.model.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

//@FeignClient(value = "currency-trade-base")
@FeignClient(name = "system-api", //注册中心的名字
        contextId = "systemClient",
        url = "${config.feign.server-system}",
        path = "/api")
public interface SystemClient {

    @PostMapping("/user/getUserRights")
    Result<Map<String, String>> getUserRights(@RequestParam("userId") long userId);
}
