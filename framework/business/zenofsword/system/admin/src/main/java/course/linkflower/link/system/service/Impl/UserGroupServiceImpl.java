package course.linkflower.link.system.service.Impl;

import course.linkflower.link.oneframework.common.constant.BaseErrorEnum;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.exception.BusinessException;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.system.dao.RoleUserGroupMapper;
import course.linkflower.link.system.dao.UserGroupMapper;
import course.linkflower.link.system.dto.role.SearchDto;
import course.linkflower.link.system.dto.usergroup.AddDto;
import course.linkflower.link.system.dto.usergroup.UpdateDto;
import course.linkflower.link.system.mapper.RoleModelMapper;
import course.linkflower.link.system.mapper.RoleUserGroupModelMapper;
import course.linkflower.link.system.mapper.UserGroupModelMapper;
import course.linkflower.link.system.model.UserGroup;
import course.linkflower.link.system.service.UserGroupService;
import course.linkflower.link.system.vo.usergroup.UserGroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupServiceImpl implements UserGroupService {
    @Autowired
    private UserGroupModelMapper ugModelMapper;
    @Autowired
    private RoleModelMapper roleModelMapper;
    @Autowired
    private UserGroupMapper ugMapper;
    @Autowired
    private RoleUserGroupMapper rugMapper;

    @Override
    public UserGroupVo add(AddDto addDto) {
        if (ugMapper.countCode(addDto.getCode())!=0){
            throw new BusinessException(BaseErrorEnum.TimeParamDuplicate.getCode(),
                    String.format(BaseErrorEnum.TimeParamError.getMessage(),"code"));
        }
        if (addDto.getOrdering()==0){
            Integer ordering=ugMapper.countLast(addDto.getType());
            if (ordering==null){
                ordering=0;
            }
            addDto.setOrdering(ordering+1);
        }
        UserGroup userGroup=ugModelMapper.addToUserGroup(addDto);
        ugMapper.add(userGroup);
        if (addDto.getRoleIds()!=null && addDto.getRoleIds().length>0){
            rugMapper.saves(userGroup.getId(),roleModelMapper.IdsToLong(addDto.getRoleIds()));
        }
        return ugModelMapper.userGroupToVo(userGroup);
    }

    @Override
    public UserGroupVo getOne(IdDto idDto) {
        UserGroup userGroup=ugMapper.getOne(Long.parseLong(idDto.getId()));
        if (userGroup == null) {
            throw new BusinessException(BaseErrorEnum.NotExist.getCode(),
                    String.format(BaseErrorEnum.NotExist.getMessage(),"userGroup"));
        }
        return ugModelMapper.userGroupToVo(userGroup);
    }

    @Override
    public void delete(IdDto idDto) {
        if (idDto.getIds()!=null && idDto.getIds().length>0){
            ugMapper.deleteAllByIds(ugModelMapper.IdsConvertLong(idDto.getIds()));
        }else {
            ugMapper.deleteAllById(Long.parseLong(idDto.getId()));
        }
    }

    @Override
    public UserGroupVo update(UpdateDto updateDto) {
        if (ugMapper.countCode(updateDto.getCode())!=0){
            throw new BusinessException(BaseErrorEnum.TimeParamDuplicate.getCode(),
                    String.format(BaseErrorEnum.TimeParamError.getMessage(),"code"));
        }
        ugMapper.update(ugModelMapper.updateToUserGroup(updateDto));
        return ugModelMapper.userGroupToVo(ugMapper.getOne(Long.parseLong(updateDto.getId())));
    }

    @Override
    public PageResult<UserGroupVo> search(SearchDto searchDto) {
        List<UserGroupVo> userGroupVos=ugMapper.search(searchDto);
        PageResult<UserGroupVo> rt=new PageResult<>();
        rt.setTotal(ugMapper.countTotal(searchDto));
        rt.setCode(0);
        rt.setPageSize(searchDto.getPageSize());
        rt.setPage(searchDto.getPage());
        rt.setData(userGroupVos);
        return rt;
    }
}
