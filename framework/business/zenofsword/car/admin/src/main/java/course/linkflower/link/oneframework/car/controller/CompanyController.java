package course.linkflower.link.oneframework.car.controller;

import course.linkflower.link.oneframework.car.dto.company.AddDto;
import course.linkflower.link.oneframework.car.dto.company.SearchDto;
import course.linkflower.link.oneframework.car.dto.company.SearchKeyDto;
import course.linkflower.link.oneframework.car.dto.company.UpdateDto;
import course.linkflower.link.oneframework.car.service.CompanyService;
import course.linkflower.link.oneframework.car.vo.company.CompanyInfoVo;
import course.linkflower.link.oneframework.car.vo.company.CompanyVo;
import course.linkflower.link.oneframework.common.constant.ApisConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(ApisConstant.ApiV1+ "/company")
@RefreshScope
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/add")
    public Result<CompanyVo> add(@RequestBody AddDto addDto){
        return Result.succeed(companyService.add(addDto));
    }

    @PostMapping("/update")
    public Result<CompanyVo> update(@RequestBody UpdateDto updateDto){
        return Result.succeed(companyService.update(updateDto));
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody IdDto idDto){
        companyService.delete(idDto);
        return Result.succeed();
    }

    @PostMapping("/getById")
    public Result<CompanyVo> getById(@RequestBody IdDto idDto){
        return Result.succeed(companyService.getById(idDto));
    }

    @PostMapping("/search")
    public PageResult<CompanyVo> search(@RequestBody SearchDto searchDto){
        return companyService.search(searchDto);
    }

    @PostMapping("/listInfoBySearchKey")
    public Result<List<CompanyInfoVo>> listInfoBySearchKey(@RequestBody SearchKeyDto searchKeyDto){
        return Result.succeed(companyService.listInfoBySearchKey(searchKeyDto));
    }
}
