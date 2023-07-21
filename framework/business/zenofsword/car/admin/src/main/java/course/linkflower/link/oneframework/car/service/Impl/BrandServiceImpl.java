package course.linkflower.link.oneframework.car.service.Impl;

import course.linkflower.link.oneframework.car.dao.BrandMapper;
import course.linkflower.link.oneframework.car.dao.CompanyMapper;
import course.linkflower.link.oneframework.car.dto.brand.AddDto;
import course.linkflower.link.oneframework.car.dto.brand.SearchDto;
import course.linkflower.link.oneframework.car.dto.brand.UpdateDto;
import course.linkflower.link.oneframework.car.mapper.BrandModelMapper;
import course.linkflower.link.oneframework.car.service.BrandService;
import course.linkflower.link.oneframework.car.vo.brand.BrandVo;
import course.linkflower.link.oneframework.car.vo.brand.SearchVo;
import course.linkflower.link.oneframework.car.vo.company.CompanyInfoVo;
import course.linkflower.link.oneframework.common.constant.BaseErrorEnum;
import course.linkflower.link.oneframework.common.constant.DbConstant;
import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.oneframework.common.exception.BusinessException;
import course.linkflower.link.oneframework.common.model.PageResult;
import course.linkflower.link.oneframework.model.Brand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandModelMapper brandModelMapper;
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private CompanyMapper companyMapper;
    @Override
    public BrandVo add(AddDto addDto) {
        if (brandMapper.countName(addDto.getName()) != 0) {
            throw new BusinessException(BaseErrorEnum.TimeParamDuplicate.getCode(),
                    String.format(BaseErrorEnum.TimeParamDuplicate.getMessage(),"name"));
        }
        Brand brand = brandModelMapper.addToBrand(addDto);
        brandMapper.add(brand);
        return brandModelMapper.brandToVo(brand);
    }

    @Override
    public  BrandVo update(UpdateDto updateDto) {
        if (brandMapper.countNamediffId(updateDto.getName(),Long.parseLong(updateDto.getId())) != 0) {
            throw new BusinessException(BaseErrorEnum.TimeParamDuplicate.getCode(),
                    String.format(BaseErrorEnum.TimeParamDuplicate.getMessage(),"name"));
        }
        Brand brand = brandModelMapper.updateToBrand(updateDto);
        brandMapper.update(brand);
        return brandModelMapper.brandToVo(brand);
    }

    @Override
    public  BrandVo getById(IdDto idDto) {
        Brand brand= brandMapper.getById(Long.parseLong(idDto.getId()));
        if (brand==null){
            throw new BusinessException(BaseErrorEnum.NotExist.getCode(),
                    String.format(BaseErrorEnum.NotExist.getMessage(),"brand"));
        }
        return brandModelMapper.brandToVo(brand);
    }

    @Override
    public void delete(IdDto idDto) {
        if (idDto.getIds()!=null && idDto.getIds().length>0){
            List<Long> ids=new ArrayList<>();
            for (String id:idDto.getIds()){
                ids.add(Long.valueOf(id));
            }
            brandMapper.deleteByIds(ids);
        }else {
            brandMapper.deleteById(Long.parseLong(idDto.getId()));
        }
    }

    @Override
    public List<BrandVo> listByCompanyId(IdDto idDto) {
        return brandModelMapper.brandsToVos(brandMapper.listByCompanyId(Long.parseLong(idDto.getId()),
                DbConstant.DefaultMaxCountLimit));
    }

    @Override
    public PageResult<SearchVo> search(SearchDto searchDto) {
        //得到name含有searchKey的company的id
        List<Long> companyIds=new ArrayList<>();
        if (StringUtils.isNotEmpty(searchDto.getSearchKey())) {
            companyIds = companyMapper.listIdBySearchKey(searchDto.getSearchKey());
        }
        //根据得到的companyId和searchKey得到brands
        List<Brand> brands=brandMapper.search(searchDto,companyIds);
        List<Long> theCompanyIds=new ArrayList<>();
        if (brands!=null && brands.size()>0) {
            for (Brand brand : brands) {
                theCompanyIds.add(brand.getCompanyId());
            }
        }
        //根据companyIds得到companyMap
        List<CompanyInfoVo> companyInfoVos=new ArrayList<>();
        if (theCompanyIds!=null && theCompanyIds.size()>0) {
            companyInfoVos = companyMapper.listInfoByIds(theCompanyIds);
        }
        Map<String,CompanyInfoVo> companyInfoVoMap=new HashMap<>();
            for (CompanyInfoVo companyInfoVo : companyInfoVos) {
                companyInfoVoMap.put(companyInfoVo.getId(), companyInfoVo);
            }
        //装载
        List<SearchVo> searchVos=SearchVo.loadFromList(brands,companyInfoVoMap);
        PageResult<SearchVo> pageResult=new PageResult<>();
        pageResult.setTotal(brandMapper.countAll(searchDto,companyIds));
        pageResult.setPageSize(searchDto.getPageSize());
        pageResult.setData(searchVos);
        pageResult.setCode(0);
        pageResult.setPage(searchDto.getPage());
        return pageResult;
    }
}
