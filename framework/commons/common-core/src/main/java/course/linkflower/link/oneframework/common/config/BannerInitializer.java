package course.linkflower.link.oneframework.common.config;

import course.linkflower.link.oneframework.common.constant.CommonConstant;
import course.linkflower.link.oneframework.common.utils.CustomBanner;
import com.nepxion.banner.BannerConstant;
import com.nepxion.banner.Description;
import com.nepxion.banner.LogoBanner;
import com.taobao.text.Color;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Banner初始化
 *
 * @author xxx
 * @date 2019/8/28
 */
public class BannerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        if (!(applicationContext instanceof AnnotationConfigApplicationContext)) {
            LogoBanner logoBanner = new LogoBanner(BannerInitializer.class, "/e2cefmp/logo.txt", "Welcome to e2cef", 10, 6, new Color[10], true);
            CustomBanner.show(logoBanner, new Description(BannerConstant.VERSION + ":", CommonConstant.PROJECT_VERSION, 0, 1)
                    , new Description("Team:", "Fly project group", 0, 1)
            );
        }
    }
}
