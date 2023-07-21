package course.linkflower.link.oneframework.house.controller;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.commission.AddDto;
import course.linkflower.link.oneframework.house.dto.commission.DeleteDto;
import course.linkflower.link.oneframework.house.dto.commission.SearchDto;
import course.linkflower.link.oneframework.house.dto.commission.UpdateDto;
import course.linkflower.link.oneframework.house.service.CommissionService;
import course.linkflower.link.oneframework.house.vo.commission.CommissionVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/commission")
@RefreshScope
public class CommissionController {
    @Autowired
    CommissionService commissionService;
    @PostMapping("/add")
    public Result<CommissionVo> add(@RequestBody AddDto addDto) {
        return commissionService.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteDto deleteDto) {
        return commissionService.delete(deleteDto);
    }

    @PostMapping("/update")
    public Result<CommissionVo> update(@RequestBody UpdateDto updateDto) {
        return commissionService.update(updateDto);
    }

    @PostMapping("/search")
    public Result<CommissionVo> search(@RequestBody SearchDto searchDto) {
        return commissionService.getById(searchDto);
    }
}
