package course.linkflower.link.oneframework.car.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "currency-trade-base")
public class CarClient {

//    @GetMapping("/api/symbolInfo/symbols")
//    Result<List<SymbolDto>> selectSymbols();
}
