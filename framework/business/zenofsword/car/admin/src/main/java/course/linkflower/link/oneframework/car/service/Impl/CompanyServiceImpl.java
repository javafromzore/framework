package course.linkflower.link.oneframework.car.service.Impl;

import course.linkflower.link.oneframework.car.dao.CompanyMapper;
import course.linkflower.link.oneframework.car.dto.company.AddDto;
import course.linkflower.link.oneframework.car.dto.company.SearchDto;
import course.linkflower.link.oneframework.car.dto.company.SearchKeyDto;
import course.linkflower.link.oneframework.car.dto.company.UpdateDto;
import course.linkflower.link.oneframework.car.mapper.CompanyModelMapper;
import course.linkflower.link.oneframework.car.service.CompanyService;
import course.linkflower.link.oneframework.car.vo.company.CompanyInfoVo;
import course.linkflower.link.oneframework.car.vo.company.CompanyVo;
import course.linkflower.link.oneframework.common.constant.BaseErrorEnum;
import course.linkflower.link.oneframework.common.exception.BusinessException;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyModelMapper companyModelMapper;
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public void delete(IdDto idDto) {
        if (idDto.getIds()!=null && idDto.getIds().length>0){
            List<Long> ids=new ArrayList<>();
            for (String s: idDto.getIds()){
                ids.add(Long.parseLong(s));
            }
            companyMapper.deleteByIds(ids);
        }else {
            companyMapper.deleteById(Long.parseLong(idDto.getId()));
        }
    }

    @Override
    public CompanyVo update(UpdateDto updateDto) {
            if(companyMapper.countNameDiffId(updateDto.getName(),Long.parseLong(updateDto.getId()))!=0){
            throw new BusinessException(BaseErrorEnum.TimeParamDuplicate.getCode(), BaseErrorEnum.TimeParamDuplicate.getMessage());
        }
        Company company = companyModelMapper.updateToCompany(updateDto);
        companyMapper.update(company);
        return companyModelMapper.companyToVo(companyMapper.getById(Long.parseLong(updateDto.getId())));
    }

    @Override
    public CompanyVo add(AddDto addDto) {
        if(companyMapper.countName(addDto.getName())!=0){
            throw new BusinessException(BaseErrorEnum.TimeParamDuplicate.getCode(), BaseErrorEnum.TimeParamDuplicate.getMessage());
        }
        Company company = companyModelMapper.addToCompany(addDto);
        companyMapper.add(company);
        return companyModelMapper.companyToVo(company);
    }

    @Override
    public CompanyVo getById(IdDto idDto) {
        Company company= companyMapper.getById(Long.parseLong(idDto.getId()));
        if (company == null) {
            throw new BusinessException(BaseErrorEnum.NotExist.getCode(), BaseErrorEnum.NotExist.getMessage());
        }
        return companyModelMapper.companyToVo(company);
    }

    @Override
    public PageResult<CompanyVo> search(SearchDto searchDto) {
        List<CompanyVo> companyVos = companyMapper.search(searchDto);
        PageResult<CompanyVo> pageResult=new PageResult<>();
        pageResult.setData(companyVos);
        pageResult.setTotal(companyMapper.countAll(searchDto));
        pageResult.setPage(searchDto.getPage());
        pageResult.setPageSize(searchDto.getPageSize());
        return pageResult;
    }

    @Override
    public List<CompanyInfoVo> listInfoBySearchKey(SearchKeyDto searchKeyDto) {
        List<CompanyInfoVo> companyInfoVos = companyMapper.listInfoBySearchKey(searchKeyDto.getSearchKey(),
                SearchKeyDto.ShowMaxCount);
        return companyInfoVos;
    }
}
