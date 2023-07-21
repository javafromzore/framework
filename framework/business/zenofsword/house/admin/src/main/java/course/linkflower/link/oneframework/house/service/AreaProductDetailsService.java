package course.linkflower.link.oneframework.house.service;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.dto.areaproductdetails.AddDto;
import course.linkflower.link.oneframework.house.dto.areaproductdetails.UpdateDto;
import course.linkflower.link.oneframework.house.dto.renthouserequestinfo.DeleteDto;
import course.linkflower.link.oneframework.house.model.AreaProductDetails;
import course.linkflower.link.oneframework.house.vo.areaproductdetails.AreaProductDetailsVo;

public interface AreaProductDetailsService {
    Result<AreaProductDetailsVo> add(AddDto addDto);
    Result delete(course.linkflower.link.oneframework.house.dto.areaproductdetails.DeleteDto deleteDto);
    Result<AreaProductDetailsVo> update(UpdateDto updateDto);
    Result<AreaProductDetails> getById(DeleteDto deleteDto);
}
