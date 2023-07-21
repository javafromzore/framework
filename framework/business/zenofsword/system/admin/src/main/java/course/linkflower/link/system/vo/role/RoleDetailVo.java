package course.linkflower.link.system.vo.role;

import course.linkflower.link.system.vo.privilege.PrivilegeInfoVo;
import course.linkflower.link.system.vo.privilegegroup.PrivilegeGroupInfoVo;
import course.linkflower.link.system.vo.user.UserInfoVo;
import course.linkflower.link.system.vo.usergroup.UserGroupInfoVo;
import lombok.Data;

import java.util.List;

@Data
public class RoleDetailVo {
    private List<UserInfoVo> userInfoVos;
    private List<UserGroupInfoVo> userGroupInfoVos;
    private List<PrivilegeGroupInfoVo> priviGroupInfoVos;
    private List<PrivilegeInfoVo> priviInfoVos;
    private List<RoleInfoVo>  roleInfoVos;
}
