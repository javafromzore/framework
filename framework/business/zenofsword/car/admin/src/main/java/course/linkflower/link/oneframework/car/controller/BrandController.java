package course.linkflower.link.oneframework.car.controller;

import course.linkflower.link.oneframework.car.dto.brand.AddDto;
import course.linkflower.link.oneframework.car.dto.brand.SearchDto;
import course.linkflower.link.oneframework.car.dto.brand.UpdateDto;
import course.linkflower.link.oneframework.car.service.BrandService;
import course.linkflower.link.oneframework.car.vo.brand.BrandVo;
import course.linkflower.link.oneframework.car.vo.brand.SearchVo;
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
@RequestMapping(ApisConstant.ApiV1 + "/carbrand")
@RefreshScope
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/add")
    public Result<BrandVo> add(@RequestBody AddDto addDto){
        return Result.succeed(brandService.add(addDto));
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody IdDto idDto){
        brandService.delete(idDto);
        return Result.succeed();
    }

    @PostMapping("/update")
    public Result<BrandVo> update(@RequestBody UpdateDto updateDto){
        return Result.succeed(brandService.update(updateDto));
    }

    @PostMapping("/getById")
    public Result<BrandVo> getById(@RequestBody IdDto idDto){
        return Result.succeed(brandService.getById(idDto));
    }

    @PostMapping("/search")
    public PageResult<SearchVo> search(@RequestBody SearchDto searchDto){
        return brandService.search(searchDto);
    }

    @PostMapping("/listByCompanyId")
    public Result<List<BrandVo>> listByCompanyId(@RequestBody IdDto idDto){
        return Result.succeed(brandService.listByCompanyId(idDto));
    }
}
