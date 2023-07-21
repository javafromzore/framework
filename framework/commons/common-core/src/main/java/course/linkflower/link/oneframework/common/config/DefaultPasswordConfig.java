package course.linkflower.link.oneframework.common.config;

import course.linkflower.link.oneframework.common.utils.PwdEncoderUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 密码加密配置类
 *
 * @author xxx
 * <p>
 * Blog: https://e2cef2000.gitee.io
 * Github: https://github.com/e2cef2000
 */
public class DefaultPasswordConfig {
	@Bean
	@ConditionalOnMissingBean
	public PasswordEncoder passwordEncoder() {
		return PwdEncoderUtil.getDelegatingPasswordEncoder("bcrypt");
	}
}
