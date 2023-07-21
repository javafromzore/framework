package course.linkflower.link.oneframework.common.filter.config;

import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
//    @EnableConfigurationProperties({ConfigProperties.class})
    @Import(ConfigProperties.class)
    public class LogAutoConfig {

//        @Bean(name = "logSession")
//        public LoginMvcConfig getLogService() {
//            return new LoginMvcConfig();
//        }
    }

