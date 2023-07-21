package course.linkflower.link.oneframework.house.controller;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.areaproductdetails.AddDto;
import course.linkflower.link.oneframework.house.dto.areaproductdetails.UpdateDto;
import course.linkflower.link.oneframework.house.dto.renthouserequestinfo.DeleteDto;
import course.linkflower.link.oneframework.house.model.AreaProductDetails;
import course.linkflower.link.oneframework.house.service.AreaProductDetailsService;
import course.linkflower.link.oneframework.house.vo.areaproductdetails.AreaProductDetailsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/areadetails")
@RefreshScope
public class AreaProductDetailsController {
    @Autowired
    AreaProductDetailsService areaProductDetailsService;
    @PostMapping("/add")
    public Result<AreaProductDetailsVo> add(@RequestBody AddDto addDto) {
        return areaProductDetailsService.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody course.linkflower.link.oneframework.house.dto.areaproductdetails.DeleteDto deleteDto) {
        return areaProductDetailsService.delete(deleteDto);
    }

    @PostMapping("/update")
    public Result<AreaProductDetailsVo> update(@RequestBody UpdateDto updateDto) {
        return areaProductDetailsService.update(updateDto);
    }

    @PostMapping("/search")
    public Result<AreaProductDetails> search(@RequestBody DeleteDto deleteDto) {
        return areaProductDetailsService.getById(deleteDto);
    }
}
