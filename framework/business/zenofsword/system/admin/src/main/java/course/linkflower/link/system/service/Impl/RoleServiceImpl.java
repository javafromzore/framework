package course.linkflower.link.system.service.Impl;

import course.linkflower.link.oneframework.common.constant.BaseErrorEnum;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.exception.BusinessException;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.system.dao.*;
import course.linkflower.link.system.dto.role.AddDto;
import course.linkflower.link.system.dto.role.SearchDto;
import course.linkflower.link.system.dto.role.UpdateDto;
import course.linkflower.link.system.mapper.RoleModelMapper;
import course.linkflower.link.system.mapper.RolePrivilegeMoldelMapper;
import course.linkflower.link.system.mapper.RoleRepulsionModelMapper;
import course.linkflower.link.system.model.Role;
import course.linkflower.link.system.service.RoleService;
import course.linkflower.link.system.vo.privilege.PrivilegeInfoVo;
import course.linkflower.link.system.vo.role.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleModelMapper roleModelMapper;
    @Autowired
    private RolePrivilegeMoldelMapper rpModelMapper;
    @Autowired
    private RoleRepulsionModelMapper rrModelMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePrivilegeMapper rpMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleUserGroupMapper rugMapper;
    @Autowired
    private RolePrivilegeGroupMapper rpgMapper;
    @Autowired
    private RoleRepulsionMapper roleRepulMapper;

    @Override
    public RoleVo add(AddDto addDto) throws BusinessException{
        if (roleMapper.countCode(addDto.getCode())!=0){
            throw new BusinessException(BaseErrorEnum.TimeParamDuplicate.getCode(),
                    String.format(BaseErrorEnum.TimeParamDuplicate.getMessage(),"code"));
        }
        if (addDto.getOrdering()==0){
            Integer ordering=roleMapper.countLast(addDto.getType());
            if (ordering==null){
                ordering=0;
            }
            addDto.setOrdering(ordering+1);
        }
        Role role=roleModelMapper.addToRole(addDto);
        roleMapper.add(role);
        if (addDto.getPriviIds()!=null && addDto.getPriviIds().length>0) {
            rpMapper.savas(rpModelMapper.IdsConvertLong(addDto.getPriviIds()), role.getId());
        }
        return roleModelMapper.roleToVo(role);
    }

    @Override
    public  RoleVo getOne(IdDto idDto) throws BusinessException{
        Role role=roleMapper.getOne(Long.parseLong(idDto.getId()));
        if (role==null){
            throw new BusinessException(BaseErrorEnum.NotExist.getCode(),
                    String.format(BaseErrorEnum.NotExist.getMessage(),"role"));
        }
        return roleModelMapper.roleToVo(role);
    }

    @Override
    public void delete(IdDto idDto) {
        if (idDto.getIds()!=null && idDto.getIds().length>0){
            roleMapper.deleteByIds(roleModelMapper.IdsConvertLong(idDto.getIds()));
            //todo 用mapstruct和stream进行转换
            roleRepulMapper.deleteByOneRoleIds(rrModelMapper.idsToLong(idDto.getIds()));
        }else {
            roleMapper.deleteById(Long.parseLong(idDto.getId()));
            roleRepulMapper.deleteByOneRoleId(Long.parseLong(idDto.getId()));
        }
    }

    @Override
    public RoleVo update(UpdateDto updateDto) throws BusinessException{
        if (roleMapper.countCodeDiffId(updateDto.getCode(),Long.parseLong(updateDto.getId()))!=0){
            throw new BusinessException(BaseErrorEnum.TimeParamDuplicate.getCode(),
                    String.format(BaseErrorEnum.TimeParamDuplicate.getMessage(),"code"));
        }
        ;
        roleMapper.update(roleModelMapper.updateToRole(updateDto));
        if (updateDto.getAfterPriviIds()!=null
                && updateDto.getAfterPriviIds().size()>0){
            rpMapper.updates(Long.parseLong(updateDto.getId()), updateDto.toPriviIds());
//            roleModelMapper.toPriviIds(updateDto.getBeforPriviIds(), updateDto.getAfterPriviIds())
        }
        return roleModelMapper.roleToVo(roleMapper.getOne(Long.parseLong(updateDto.getId())));
    }

    @Override
    public PageResult<RoleVo> search(SearchDto searchDto) {
        List<RoleVo> roleVos=roleMapper.search(searchDto);
        PageResult<RoleVo> rt=new PageResult<>();
        rt.setCode(0);
        rt.setData(roleVos);
        rt.setPage(searchDto.getPage());
        rt.setPageSize(searchDto.getPageSize());
        rt.setTotal(roleMapper.countTotal(searchDto));
        return rt;
    }

    @Override
    public RoleDetailVo detail(IdDto idDto) {
//        List<UserInfoVo> userInfoVos=;
//        List<UserGroupInfoVo> userGroupInfoVos=;
//        List<PrivilegeGroupInfoVo> priviGroupInfoVos=;
//        List<PrivilegeInfoVo> priviInfoVos=;
//        List<RoleInfoVo> roleInfoVos=
        //stream滤去得到的null
        List<Long> anotherIds=roleRepulMapper.listAnotherId(Long.parseLong(idDto.getId()));
        List<RoleInfoVo> roleInfoVos=null;
        if (anotherIds!=null && anotherIds.size()>0){
            anotherIds=anotherIds
                    .stream()
                    .filter(id -> id!=null).
                    collect(Collectors.toList());
            roleInfoVos=roleMapper.listInfo(anotherIds);
        }
        return roleModelMapper.toDetail(
                userRoleMapper.UserInfo(Long.parseLong(idDto.getId())),
                rugMapper.userGroupInfo(Long.parseLong(idDto.getId())),
                rpgMapper.priviGroupInfo(Long.parseLong(idDto.getId())),
                rpMapper.priviInfo(Long.parseLong(idDto.getId())),
                roleInfoVos
                );
    }
}
