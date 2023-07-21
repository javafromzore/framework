package course.linkflower.link.oneframework.house.service.impl;

import course.linkflower.link.oneframework.common.model.Result;
import course.linkflower.link.oneframework.house.consts.HouseConstant;
import course.linkflower.link.oneframework.house.dao.*;
import course.linkflower.link.oneframework.house.dto.base.IdDto;
import course.linkflower.link.oneframework.house.dto.housedevicetype.HousePageDto;
import course.linkflower.link.oneframework.house.dto.renthouseinfo.*;
import course.linkflower.link.oneframework.house.model.*;
import course.linkflower.link.oneframework.house.service.RentHouseInfoService;
import course.linkflower.link.oneframework.house.vo.areainfo.AreaInfoVo;
import course.linkflower.link.oneframework.house.vo.commission.CommissionVo;
import course.linkflower.link.oneframework.house.vo.communityinfo.CommunityInfoVo;
import course.linkflower.link.oneframework.house.vo.housedevicetype.HouseDeviceTypeVo;
import course.linkflower.link.oneframework.house.vo.housedictionary.HouseDictionaryVo;
import course.linkflower.link.oneframework.house.vo.househightlightinfo.HouseHightlightInfoVo;
import course.linkflower.link.oneframework.house.vo.renthouseinfo.HouseDetailsInfoVo;
import course.linkflower.link.oneframework.house.vo.renthouseinfo.RentHouseInfoVo;
import course.linkflower.link.oneframework.house.vo.renthouseinfo.ShortHouseInfoVo;
import course.linkflower.link.oneframework.house.vo.renthouserequestinfo.RentHouseRequestInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RentHouseInfoServiceImpl implements RentHouseInfoService {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RentHouseInfoMapper rentHouseInfoMapper;
    @Autowired
    AreaInfoMapper areaInfoMapper;
    @Autowired
    AreaProductDetailsMapper areaProductDetailsMapper;
    @Autowired
    HouseDeviceMapper houseDeviceMapper;
    @Autowired
    HouseHighlightMapper houseHighlightMapper;
    @Autowired
    RentHouseRequestMapper rentHouseRequestMapper;
    @Autowired
    HouseDictionaryMapper houseDictionaryMapper;
    @Autowired
    HouseDeviceTypeMapper houseDeviceTypeMapper;
    @Autowired
    HouseHightlightInfoMapper houseHightlightInfoMapper;
    @Autowired
    RentHouseRequestInfoMapper rentHouseRequestInfoMapper;
    @Autowired
    CommunityInfoMapper communityInfoMapper;
    @Autowired
    CommissionMapper commissionMapper;
    @Override
    public Result<RentHouseInfoVo> add(AddDto addDto) {

        redisTemplate.opsForHash().put("test", "key1", "value1");
        Map a = redisTemplate.opsForHash().entries("test");

        RentHouseInfo rentHouseInfo = addDto.toModel();
        rentHouseInfoMapper.save(rentHouseInfo);
        //整合数据
        RentHouseInfoVo rentHouseInfoVo = new RentHouseInfoVo().loadFrom(rentHouseInfo);
        if (addDto.getAreaInfoIds() != null && addDto.getAreaInfoIds().length > 0) {
            //多对多添加区域信息
            areaProductDetailsMapper.saves(rentHouseInfo.getId(), HouseConstant.stringToLong(addDto.getAreaInfoIds()));
        }
        if (addDto.getDeviceIds() != null && addDto.getDeviceIds().length > 0) {
            //多对多添加设备信息
            houseDeviceMapper.saves(rentHouseInfo.getId(), HouseConstant.stringToLong(addDto.getDeviceIds()));
        }
        if (addDto.getHighlightInfoIds() != null && addDto.getHighlightInfoIds().length > 0) {
            //多对多添加亮点信息
            houseHighlightMapper.saves(rentHouseInfo.getId(), HouseConstant.stringToLong(addDto.getHighlightInfoIds()));
        }
        if (addDto.getRentRequestInfoIds() != null && addDto.getRentRequestInfoIds().length > 0) {
            //多对多添加要求信息
            rentHouseRequestMapper.saves(rentHouseInfo.getId(), HouseConstant.stringToLong(addDto.getRentRequestInfoIds()));
        }
        return Result.succeed(rentHouseInfoVo);
    }

    @Override
    public Result delete(DeleteDto deleteDto) {
        if (!StringUtils.isEmpty(deleteDto.getId()) && deleteDto.getIds()==null) {
            rentHouseInfoMapper.delete(Long.parseLong(deleteDto.getId()));
        }
        if (StringUtils.isEmpty(deleteDto.getId()) && deleteDto.getIds()!=null) {
            rentHouseInfoMapper.deleteAll(HouseConstant.stringToLong(deleteDto.getIds()));
        }
        return Result.succeed();
    }

    @Override
    public Result<RentHouseInfoVo> update(AddDto addDto) {
        RentHouseInfo rentHouseInfo =  addDto.toModel();
        rentHouseInfoMapper.update(rentHouseInfo);
        Map<Long,AreaInfo> areaTypes = new HashMap<>();
        //整合数据
        RentHouseInfoVo rentHouseInfoVo = new RentHouseInfoVo().loadFrom(rentHouseInfo);
        //多对多删除
        if (addDto.getAreaInfoIds() != null && addDto.getAreaInfoIds().length > 0) {
            areaProductDetailsMapper.deletes(Long.parseLong(addDto.getId()));
        }
        if (addDto.getDeviceIds() != null && addDto.getAreaInfoIds().length > 0) {
            houseDeviceMapper.deletes(Long.parseLong(addDto.getId()));
        }
        if (addDto.getHighlightInfoIds() != null && addDto.getAreaInfoIds().length > 0) {
            houseHighlightMapper.deletes(Long.parseLong(addDto.getId()));
        }
        if (addDto.getRentRequestInfoIds() != null && addDto.getAreaInfoIds().length > 0) {
            rentHouseRequestMapper.deletes(Long.parseLong(addDto.getId()));
        }
        if (addDto.getAreaInfoIds() != null && addDto.getAreaInfoIds().length > 0) {
            //多对多添加区域信息
            areaProductDetailsMapper.saves(rentHouseInfo.getId(), HouseConstant.stringToLong(addDto.getAreaInfoIds()));
        }
        //找到区域信息表，和多对多关联表的信息
        List<AreaInfo> areaTypeVos = areaInfoMapper.listByIds(HouseConstant.stringToLong(addDto.getAreaInfoIds()));
        List<AreaProductDetails> areaProductDetails  = areaProductDetailsMapper.listByIds(HouseConstant.stringToLong(addDto.getAreaInfoIds()));
        //多对多表存放修改后的区域的信息
        for (AreaInfo areaTypeVo : areaTypeVos){
            areaTypes.put(areaTypeVo.getId() ,areaTypeVo);
        }
        for (AreaProductDetails d : areaProductDetails){
                AreaInfo areaTypeVo = areaTypes.get(d.getAreaInfoId());
                d.setAreaType(areaTypeVo.getType());
                d.setAreaLevel(areaTypeVo.getLevel());
                d.setTargetType(HouseConstant.targetType);
        }
        areaProductDetailsMapper.updates(areaProductDetails);
        if (addDto.getDeviceIds() != null && addDto.getDeviceIds().length > 0) {
            //多对多添加设备信息
            houseDeviceMapper.saves(rentHouseInfo.getId(), HouseConstant.stringToLong(addDto.getDeviceIds()));
        }
        if (addDto.getHighlightInfoIds() != null && addDto.getHighlightInfoIds().length > 0) {
            //多对多添加亮点信息
            houseHighlightMapper.saves(rentHouseInfo.getId(), HouseConstant.stringToLong(addDto.getHighlightInfoIds()));
        }
        if (addDto.getRentRequestInfoIds() != null && addDto.getRentRequestInfoIds().length > 0) {
            //多对多添加要求信息
            rentHouseRequestMapper.saves(rentHouseInfo.getId(), HouseConstant.stringToLong(addDto.getRentRequestInfoIds()));
        }
        return Result.succeed(rentHouseInfoVo);
    }

    @Override
    public Result<RentHouseInfoVo> getById(IdDto idDto) {
        return Result.succeed(new RentHouseInfoVo().loadFrom(rentHouseInfoMapper.getById(Long.parseLong(idDto.getId()))));
    }

    @Override
    public HousePageResult<ShortHouseInfoVo> search(HousePageDto housePageDto) {
        List<ShortHouseInfoVo> shortHouseInfoVos = rentHouseInfoMapper.search(housePageDto);
        HousePageResult<ShortHouseInfoVo> housePageResult =new HousePageResult<>();
        housePageResult.setData(shortHouseInfoVos);
        housePageResult.setCount(rentHouseInfoMapper.countAll());
        housePageResult.setPage(housePageDto.getPage());
        return housePageResult;
    }

    @Override
    public Result<HouseDetailsInfoVo> details(IdDto idDto) {
        HouseDetailsInfoVo houseDetailsInfoVo = new HouseDetailsInfoVo();
        //获得租房信息
        RentHouseInfo rentHouseInfo = rentHouseInfoMapper.getById(Long.parseLong(idDto.getId()));
        List<Long> dictionaryIds = new ArrayList<>();
        //装载字典id
        dictionaryIds.add(rentHouseInfo.getDepositTypeId());
        dictionaryIds.add(rentHouseInfo.getRentHouseTypeId());
        dictionaryIds.add(rentHouseInfo.getDecorateTypeId());
        dictionaryIds.add(rentHouseInfo.getOrientationId());
        dictionaryIds.add(rentHouseInfo.getStoreyId());
        // 装载字典数据
        List<HouseDictionaryVo> houseDictionaryVo = new ArrayList<>();
        List<HouseDictionary> houseDictionaries = houseDictionaryMapper.ListByIds(dictionaryIds);
        for (HouseDictionary houseDictionary : houseDictionaries){
            houseDictionaryVo.add(new HouseDictionaryVo().loadFrom(houseDictionary));
        }
        //装载小区数据
        List<AreaInfo> areaInfos = areaInfoMapper.listByHouseId(Long.parseLong(idDto.getId()),HouseConstant.targetType);
        List<AreaInfoVo> hfo = new ArrayList<>();
        for (AreaInfo areaInfo : areaInfos){
            hfo.add(new AreaInfoVo().loadFrom(areaInfo));
        }
        //装载房屋设备信息
        List<HouseDeviceType> houseDeviceTypes = houseDeviceTypeMapper.listByHouseId(Long.parseLong(idDto.getId()));
        List<HouseDeviceTypeVo> houseDeviceTypeVo = new ArrayList<>();
        for (HouseDeviceType houseDeviceType : houseDeviceTypes){
            houseDeviceTypeVo.add(new HouseDeviceTypeVo().loadFrom(houseDeviceType));
        }
        //装载亮点信息
        List<HouseHightlightInfo> houseHightlightInfos = houseHightlightInfoMapper.listByHouseId(Long.parseLong(idDto.getId()));
        List<HouseHightlightInfoVo> houseHightlightInfoVos = new ArrayList<>();
        for (HouseHightlightInfo h : houseHightlightInfos){
            houseHightlightInfoVos.add(new HouseHightlightInfoVo().loadFrom(h));
        }
        //装载出租要求
        List<RentHouseRequestInfo> rentHouseRequestInfos = rentHouseRequestInfoMapper.listByHouseId(Long.parseLong(idDto.getId()));
        List<RentHouseRequestInfoVo> rentHouseRequestInfoVos = new ArrayList<>();
        for (RentHouseRequestInfo rentHouseRequestInfo : rentHouseRequestInfos){
            rentHouseRequestInfoVos.add(new RentHouseRequestInfoVo().loadFrom(rentHouseRequestInfo));
        }
        houseDetailsInfoVo.setRentHouseRequestInfoVos(rentHouseRequestInfoVos);
        houseDetailsInfoVo.setHouseHightlightInfoVos(houseHightlightInfoVos);
        houseDetailsInfoVo.setHouseDeviceTypeVos(houseDeviceTypeVo);
        houseDetailsInfoVo.setCommunityInfoVo(new CommunityInfoVo().loadFrom(communityInfoMapper.getById(rentHouseInfo.getCommunityInfoId())));
        houseDetailsInfoVo.setCommissionVo(new CommissionVo().loadFrom(commissionMapper.getById(rentHouseInfo.getCommissionId())));
        houseDetailsInfoVo.setHouseDictionaryVos(houseDictionaryVo);
        houseDetailsInfoVo.setHouseAreaInfoVos(hfo);
        houseDetailsInfoVo.loadFrom(rentHouseInfo);
        return Result.succeed(houseDetailsInfoVo);
    }
}
