package course.linkflower.link.system.service.Impl;

import course.linkflower.link.oneframework.common.constant.BaseErrorEnum;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.exception.BusinessException;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.system.dao.PrivilegeGroupMapper;
import course.linkflower.link.system.dao.PrivilegePrivilegeGroupMapper;
import course.linkflower.link.system.dto.privilegegroup.AddDto;
import course.linkflower.link.system.dto.privilegegroup.SearchDto;
import course.linkflower.link.system.dto.privilegegroup.UpdateDto;
import course.linkflower.link.system.mapper.PrivilegeGroupModelMapper;
import course.linkflower.link.system.mapper.PrivilegeModelMapper;
import course.linkflower.link.system.model.PrivilegeGroup;
import course.linkflower.link.system.service.PrivilegeGroupService;
import course.linkflower.link.system.vo.privilegegroup.PrivilegeGroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivilegeGroupServiceImpl implements PrivilegeGroupService {
    @Autowired
    private PrivilegeGroupModelMapper pgModelMapper;
    @Autowired
    private PrivilegeModelMapper privilegeModelMapper;
    @Autowired
    private PrivilegeGroupMapper pgMapper;
    @Autowired
    private PrivilegePrivilegeGroupMapper ppgMapper;
    @Override

    public PrivilegeGroupVo add(AddDto addDto) {
        if (pgMapper.countCode(addDto.getCode())!=0){
            throw new BusinessException(BaseErrorEnum.TimeParamDuplicate.getCode(),
                    String.format(BaseErrorEnum.TimeParamError.getMessage(),"code"));
        }
        if (addDto.getOrdering()==0){
            Integer ordering=pgMapper.countLast(addDto.getType());
            if (ordering==null){
                ordering=0;
            }
            addDto.setOrdering(ordering+1);
        }
        PrivilegeGroup priviGroup=pgModelMapper.addToPrivilegeGroup(addDto);
        pgMapper.add(priviGroup);
        ppgMapper.saves(priviGroup.getId(),privilegeModelMapper.IdsToLong(addDto.getPriviIds()));
        return pgModelMapper.priviGroupToVo(priviGroup);
    }

    @Override
    public PrivilegeGroupVo getOne(IdDto idDto) {
        PrivilegeGroup priviGroup=pgMapper.getOne(Long.parseLong(idDto.getId()));
        if (priviGroup == null) {
            throw new BusinessException(BaseErrorEnum.NotExist.getCode(),
                    String.format(BaseErrorEnum.NotExist.getMessage(),"priviGroup"));
        }
        return pgModelMapper.priviGroupToVo(priviGroup);
    }

    @Override
    public void delete(IdDto idDto) {
        if (idDto.getIds()!=null && idDto.getIds().length>0){
            pgMapper.deleteAllByIds(pgModelMapper.IdsConvertLong(idDto.getIds()));
        }else {
            pgMapper.deleteAllById(Long.parseLong(idDto.getId()));
        }
    }

    @Override
    public PrivilegeGroupVo update(UpdateDto updateDto) {
        if (pgMapper.countCode(updateDto.getCode())!=0){
            throw new BusinessException(BaseErrorEnum.TimeParamDuplicate.getCode(),
                    String.format(BaseErrorEnum.TimeParamError.getMessage(),"code"));
        }
        pgMapper.update(pgModelMapper.updateToPrivilegeGroup(updateDto));
        return pgModelMapper.priviGroupToVo(pgMapper.getOne(Long.parseLong(updateDto.getId())));
    }

    @Override
    public PageResult<PrivilegeGroupVo> search(SearchDto searchDto) {
        List<PrivilegeGroupVo> priviGroupVos=pgMapper.search(searchDto);
        PageResult<PrivilegeGroupVo> rt=new PageResult<>();
        rt.setTotal(pgMapper.countTotal(searchDto));
        rt.setCode(0);
        rt.setPageSize(searchDto.getPageSize());
        rt.setPage(searchDto.getPage());
        rt.setData(priviGroupVos);
        return rt;
    }
}
