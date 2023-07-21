package course.linkflower.link.oneframework.house.service;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.menu.AddDto;
import course.linkflower.link.oneframework.house.dto.menu.DeleteDto;
import course.linkflower.link.oneframework.house.dto.menu.SearchDto;
import course.linkflower.link.oneframework.house.dto.menu.UpdateDto;
import course.linkflower.link.oneframework.house.vo.menu.MenuVo;

public interface MenuService {
    Result<MenuVo> add(AddDto addDto);
    Result<MenuVo> update(UpdateDto updateDto);
    Result delete(DeleteDto deleteDto);
    Result<MenuVo> getById(SearchDto searchDto);
//    Result<MenuTreeVo> listMenuTreeByCode(String code);
}
