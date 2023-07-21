package course.linkflower.link.system.service.Impl;

import course.linkflower.link.oneframework.common.constant.BaseErrorEnum;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.exception.BusinessException;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.system.dao.PrivilegeMapper;
import course.linkflower.link.system.dto.privilege.AddDto;
import course.linkflower.link.system.dto.privilege.SearchDto;
import course.linkflower.link.system.dto.privilege.UpdateDto;
import course.linkflower.link.system.mapper.PrivilegeModelMapper;
import course.linkflower.link.system.model.Privilege;
import course.linkflower.link.system.service.PrivilegeService;
import course.linkflower.link.system.vo.privilege.PrivilegeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
    @Autowired
    private PrivilegeModelMapper priviModelMapper;
    @Autowired
    private PrivilegeMapper priviMapper;
    @Override
    public PrivilegeVo add(AddDto addDto) throws BusinessException{
        if (priviMapper.countCode(addDto.getCode())!=0){
            throw new BusinessException(BaseErrorEnum.TimeParamDuplicate.getCode(),
                    String.format(BaseErrorEnum.TimeParamError.getMessage(),"code"));
        }
        if (addDto.getOrdering()==0){
            Integer ordering=priviMapper.countLast(addDto.getType());
            if (ordering==null){
                ordering=0;
            }
            addDto.setOrdering(ordering+1);
        }
        Privilege privi=priviModelMapper.addToPrivi(addDto);
        priviMapper.add(privi);
        return priviModelMapper.priviToVo(privi);
    }

    @Override
    public void delete(IdDto idDto) {
        if (idDto.getIds()!=null && idDto.getIds().length>0){
            priviMapper.deleteAllByIds(priviModelMapper.IdsConvertLong(idDto.getIds()));
        }else {
            priviMapper.deleteAllById(Long.parseLong(idDto.getId()));
        }
    }

    @Override
    public PrivilegeVo update(UpdateDto updateDto) throws BusinessException{
        if (priviMapper.countCode(updateDto.getCode())!=0){
            throw new BusinessException(BaseErrorEnum.TimeParamDuplicate.getCode(),
                    String.format(BaseErrorEnum.TimeParamError.getMessage(),"code"));
        }
        priviMapper.update(priviModelMapper.updateToPrivi(updateDto));
        return priviModelMapper.priviToVo(priviMapper.getOne(Long.parseLong(updateDto.getId())));
    }

    @Override
    public PageResult<PrivilegeVo> search(SearchDto searchDto) {
        List<PrivilegeVo> privilegeVos=priviMapper.search(searchDto);
        PageResult<PrivilegeVo> rt=new PageResult<>();
        rt.setTotal(priviMapper.countTotal(searchDto));
        rt.setCode(0);
        rt.setPageSize(searchDto.getPageSize());
        rt.setPage(searchDto.getPage());
        rt.setData(privilegeVos);
        return rt;
    }

    @Override
    public PrivilegeVo getOne(IdDto idDto) throws BusinessException{
        Privilege privi=priviMapper.getOne(Long.parseLong(idDto.getId()));
        if (privi == null) {
            throw new BusinessException(BaseErrorEnum.NotExist.getCode(),
                    String.format(BaseErrorEnum.NotExist.getMessage(),"privilege"));
        }
        return priviModelMapper.priviToVo(privi);
    }
}
