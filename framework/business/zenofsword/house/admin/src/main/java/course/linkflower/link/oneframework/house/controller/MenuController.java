package course.linkflower.link.oneframework.house.controller;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.menu.AddDto;
import course.linkflower.link.oneframework.house.dto.menu.DeleteDto;
import course.linkflower.link.oneframework.house.dto.menu.SearchDto;
import course.linkflower.link.oneframework.house.dto.menu.UpdateDto;
import course.linkflower.link.oneframework.house.service.MenuService;
import course.linkflower.link.oneframework.house.vo.menu.MenuVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/menu")
@RefreshScope
public class MenuController {
    @Autowired
    MenuService menuService;

    @PostMapping("/add")
    public Result<MenuVo> add(@Validated @RequestBody AddDto addDto) {
        return menuService.add(addDto);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody DeleteDto deleteDto) {
        return menuService.delete(deleteDto);
    }

    @PostMapping("/update")
    public Result<MenuVo> update(@RequestBody UpdateDto updateDto) {
        return menuService.update(updateDto);
    }

    @PostMapping("/search")
    public Result<MenuVo> search(@RequestBody SearchDto searchDto) {
        return menuService.getById(searchDto);
    }
}
