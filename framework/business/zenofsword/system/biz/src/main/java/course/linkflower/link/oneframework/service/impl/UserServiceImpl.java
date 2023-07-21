package course.linkflower.link.oneframework.service.impl;

import cn.hutool.captcha.LineCaptcha;
import course.linkflower.link.oneframework.common.constant.BaseErrorEnum;
import course.linkflower.link.oneframework.common.exception.BusinessException;
import course.linkflower.link.oneframework.consts.RegexConst;
import course.linkflower.link.oneframework.dao.UserMapper;
import course.linkflower.link.oneframework.dto.user.NameDto;
import course.linkflower.link.oneframework.dto.user.PasswordDto;
import course.linkflower.link.oneframework.dto.user.SendAuthCodeDto;
import course.linkflower.link.oneframework.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private StringRedisTemplate strRedisTemplate;
    @Autowired
    private UserMapper userMapper;
    @Override
    public void sendRobotCode(ServletResponse servletResponse, String userCode) throws IOException {
        //制造人机码
        LineCaptcha lineCaptcha=new LineCaptcha(200,80,4,100);
        //转化成string放入redis
        String robotCode=lineCaptcha.getCode();
        strRedisTemplate.opsForValue().set(userCode,robotCode,5, TimeUnit.MINUTES);
        //写入输入流
        ServletOutputStream outputStream=servletResponse.getOutputStream();
        lineCaptcha.write(outputStream);
    }

    @Override
    public Boolean judgePassword(PasswordDto passwordDto) throws BusinessException {
        if (!passwordDto.getPassword().matches(RegexConst.PASSWORD_REGEX)){
            throw new BusinessException(BaseErrorEnum.FalsePwdFormat.getCode(), BaseErrorEnum.FalsePwdFormat.getMessage());
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean sendAuthCode(SendAuthCodeDto sendAuthCodeDto) throws BusinessException{
        if (StringUtils.isNotEmpty(sendAuthCodeDto.getPhone())) {
            //判断手机号是否符合正则
            if (!sendAuthCodeDto.getPhone().matches(RegexConst.USERNAME_REGEX)) {
                throw new BusinessException(BaseErrorEnum.NoRightPhoneNum.getCode(),
                        String.format(BaseErrorEnum.NoRightPhoneNum.getMessage(),sendAuthCodeDto.getPhone()));
            }
            //判断手机号是否已经被注册
            if (userMapper.countPhone(sendAuthCodeDto.getPhone()) > 0) {
                throw new BusinessException(BaseErrorEnum.PhoneExistError.getCode(),
                        String.format(BaseErrorEnum.PhoneExistError.getMessage()));
            }
        }else {
            //判断邮箱号是否符合正则
            if (!sendAuthCodeDto.getPhone().matches(RegexConst.USERNAME_REGEX)) {
                throw new BusinessException(BaseErrorEnum.NoRightPhoneNum.getCode(),
                        String.format(BaseErrorEnum.NoRightPhoneNum.getMessage(),sendAuthCodeDto.getEmail()));
            }
            //判断邮箱号是否已经被注册
            if (userMapper.countPhone(sendAuthCodeDto.getPhone()) > 0) {
                throw new BusinessException(BaseErrorEnum.EmailExistError.getCode(),
                        String.format(BaseErrorEnum.EmailExistError.getMessage(),sendAuthCodeDto.getEmail()));
            }
        }
        //判断人机码是否正确
        if (StringUtils.isEmpty(sendAuthCodeDto.getCheckCode())){
            throw new BusinessException(BaseErrorEnum.NoVerifyError.getCode(),
                    String.format(BaseErrorEnum.NoVerifyError.getMessage()));
        }
        if (!sendAuthCodeDto.getCheckCode().equals(strRedisTemplate.opsForValue().get(sendAuthCodeDto.getUserCode()))){
            throw new BusinessException(BaseErrorEnum.FalseRobotCode.getCode(), BaseErrorEnum.FalseRobotCode.getMessage());
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean judgeName(NameDto nameDto) {
        if (!nameDto.getName().matches(RegexConst.USERNAME_REGEX)){
            throw new BusinessException(BaseErrorEnum.FalseNameFormatError.getCode(), BaseErrorEnum.FalseNameFormatError.getMessage());
        }
        if (userMapper.countName(nameDto.getName())>0){
            throw new BusinessException(BaseErrorEnum.NameExist.getCode(), BaseErrorEnum.NameExist.getMessage());
        }
        return Boolean.TRUE;
    }
}
