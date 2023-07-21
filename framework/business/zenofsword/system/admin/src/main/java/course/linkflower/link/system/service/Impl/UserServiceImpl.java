package course.linkflower.link.system.service.Impl;

import course.linkflower.link.oneframework.common.dto.base.IdDto;

import course.linkflower.link.system.dao.*;
//import course.linkflower.link.system.dto.user.NameDto;
//import course.linkflower.link.system.dto.user.PasswordDto;
import course.linkflower.link.system.mapper.PrivilegeModelMapper;
import course.linkflower.link.system.mapper.PrivilegePrivilegeGroupModelMapper;
import course.linkflower.link.system.service.UserService;
import course.linkflower.link.system.vo.privilege.CodeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PrivilegeModelMapper priviModelMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private UserUserGroupMapper uugMapper;
    @Autowired
    private RoleUserGroupMapper rugMapper;
    @Autowired
    private RolePrivilegeMapper rpMapper;
    @Autowired
    private RolePrivilegeGroupMapper rpgMapper;
    @Autowired
    private PrivilegePrivilegeGroupModelMapper ppgMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public List<CodeVo> privilege(IdDto idDto) {
        //通过user_role找到的roleIds(即user直接拥有的role身份)
        List<Long> roleIds=userRoleMapper.roleIds(Long.parseLong(idDto.getId()));
        //包含该user的user_group的id
        List<Long> userGroupIds=uugMapper.userGroupIds(Long.parseLong(idDto.getId()));
        if (userGroupIds!=null && userGroupIds.size()!=0) {
            List<Long> indirectRoleIds = rugMapper.roleIdsByIds(userGroupIds);
            roleIds = Stream.concat(roleIds.stream(), indirectRoleIds.stream()).collect(Collectors.toList());
        }
        //user直接或者间接拥有role身份才搜索权限
        if (roleIds==null && roleIds.size()==0) {
            return null;
        }
        //通过role_privilege找到的privilegeCode(即role直接拥有的privilege)
        List<CodeVo> codeVos = rpMapper.priviCodesByIds(roleIds);
        List<Long> priviGroupIds=rpgMapper.priviGroupIdsByIds(roleIds);
        if (priviGroupIds != null && priviGroupIds.size() != 0) {
            List<CodeVo> indirectCodeVos=ppgMapper.priviCodesByIds(priviGroupIds);
            codeVos=Stream.concat(codeVos.stream(),indirectCodeVos.stream()).collect(Collectors.toList());
        }
        return codeVos;
    }

    @Override
    public Map<String, String> getUserRights(long userId) {
        /*Long[] roleIds = loginMapper.getRoleIdsById(id);
        Long[] privilegeIds = loginMapper.getPrivilegeIdsByRoleIds(roleIds);
        List<Privilege> privileges = loginMapper.getPrivilegesByIds(privilegeIds);
        Map<Long, Boolean> fuPrivilegeIds = new HashMap<>();
        //1000,  10 * 1000
        if (privileges!=null && privileges.size() != 0) {
            for (Privilege privilege : privileges) {
                if (privilege.getParentId() != null) {
                    fuPrivilegeIds.put(privilege.getParentId(), Boolean.TRUE);
                }
            }

            Map<Long, Privilege>  parentPrivileges = new HashMap<>();
            for (Privilege privilege : loginMapper.getFuPrivilegesByIds(fuPrivilegeIds.keySet())) {
                parentPrivileges.put(privilege.getId(), privilege);
            }

            Map<String, String> rightsMap = new HashMap<>();

            for (Privilege privilege1 : privileges) {
                Privilege parent = parentPrivileges.get(privilege1.getParentId());
                if (parent != null) {
                    String right = parent.getCode() + ":" + privilege1.getCode();
                    rightsMap.put(right, right);
                }
            }


        }*/

        return new HashMap<>();
    }


}
