package course.linkflower.link.oneframework.house.service.impl;

import course.linkflower.link.oneframework.common.constant.BaseErrorContst;
import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dao.MenuMapper;
import course.linkflower.link.oneframework.house.dto.menu.AddDto;
import course.linkflower.link.oneframework.house.dto.menu.DeleteDto;
import course.linkflower.link.oneframework.house.dto.menu.SearchDto;
import course.linkflower.link.oneframework.house.dto.menu.UpdateDto;
import course.linkflower.link.oneframework.house.model.Menu;
import course.linkflower.link.oneframework.house.service.MenuService;
import course.linkflower.link.oneframework.house.vo.menu.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    public Result<MenuVo> add(AddDto addDto) {
        Menu menu = addDto.toModel();
        if (addDto.getCode()!=null){
            if (menuMapper.countByCode(addDto.getCode())!=0){
                Result.of(null, BaseErrorContst.BaseErrorTimeParamDuplicateError,
                        BaseErrorContst.BaseMsgTimeParamsDuplicateError);
            }
        }
        menuMapper.save(menu);
        return Result.succeed(new MenuVo().loadFrom(menu));
    }

    @Override
    public Result<MenuVo> update(UpdateDto updateDto) {
        Menu m = updateDto.toModel();
        menuMapper.update(m);
        return Result.succeed(new MenuVo().loadFrom(m));
    }

    @Override
    public Result delete(DeleteDto deleteDto) {
        return Result.succeed(menuMapper.delete(Long.parseLong(deleteDto.getId())));
    }

    @Override
    public Result<MenuVo> getById(SearchDto searchDto) {
        return Result.succeed(new MenuVo().loadFrom(menuMapper.getById(Long.parseLong(searchDto.getId()))));
    }

//    @Override
//    public Result<MenuTreeVo> listMenuTreeByCode(String code) {
//        List<MenuTreeVo> topics = menuMapper.listMenuTreeByParentCode(code);
//        return Result.succeed(MenuTreeVo.loadFromList(topics));
//    }
}
