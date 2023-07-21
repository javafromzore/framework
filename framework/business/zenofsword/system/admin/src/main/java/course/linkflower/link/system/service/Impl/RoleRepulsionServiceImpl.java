package course.linkflower.link.system.service.Impl;

import course.linkflower.link.oneframework.common.constant.BaseErrorEnum;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.exception.BusinessException;
import course.linkflower.link.system.dao.RoleRepulsionMapper;
import course.linkflower.link.system.dto.rolerepulsion.AddDto;
import course.linkflower.link.system.dto.rolerepulsion.DeleteDto;
import course.linkflower.link.system.dto.rolerepulsion.UpdateDto;
import course.linkflower.link.system.mapper.RoleRepulsionModelMapper;
import course.linkflower.link.system.model.RoleRepulsion;
import course.linkflower.link.system.service.RoleRepulsionService;
import course.linkflower.link.system.vo.rolerepulsion.RoleRepulsionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleRepulsionServiceImpl implements RoleRepulsionService {
    @Autowired
    private RoleRepulsionModelMapper rrModelMapper;
    @Autowired
    private RoleRepulsionMapper roleRepulMapper;
    @Override
    public RoleRepulsionVo add(AddDto addDto) throws BusinessException{
        if (roleRepulMapper.countRoleId(Long.parseLong(addDto.getRoleIdA()),Long.parseLong(addDto.getRoleIdB()))!=0){
            throw new BusinessException(BaseErrorEnum.TimeParamDuplicate.getCode(),
                    String.format(BaseErrorEnum.TimeParamError.getMessage(),"role"));
        }
        RoleRepulsion roleRepul=rrModelMapper.addToRoleRepul(addDto);
        roleRepulMapper.add(roleRepul);
        return rrModelMapper.roleRepulToVo(roleRepul);
    }

    @Override
    public void delete(DeleteDto deleteDto) {
        roleRepulMapper.deleteByRoleIds(deleteDto.toRoleDtos());
        /*rrModelMapper.toRoleIdDtos(deleteDto.getRoleIdA(),deleteDto.getRoleIdB())*/
    }

    @Override
    public RoleRepulsionVo update(UpdateDto updateDto) {
        RoleRepulsion roleRepul=rrModelMapper.updateToRoleRepul(updateDto);
        roleRepulMapper.update(roleRepul);
        return rrModelMapper.roleRepulToVo(roleRepul);
    }

    @Override
    public RoleRepulsionVo getOne(IdDto idDto) throws BusinessException{
        RoleRepulsion roleRepul=roleRepulMapper.getOne(Long.parseLong(idDto.getId()));
        if (roleRepul == null) {
            throw new BusinessException(BaseErrorEnum.NotExist.getCode(),
                    String.format(BaseErrorEnum.NotExist.getMessage(),"roleRepulsion"));
        }
        return rrModelMapper.roleRepulToVo(roleRepul);
    }
}
