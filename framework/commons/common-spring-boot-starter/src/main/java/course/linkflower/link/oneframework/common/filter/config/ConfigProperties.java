package course.linkflower.link.oneframework.common.filter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


    @Component("ConfigProperties")
//    @ConfigurationProperties("login.interceptor")

    public class ConfigProperties {
        private String headName="authorization";
        private int substringIndex = 7;
        private  String loginToken = "login:token:";

        public String getHeadName() {
            return headName;
        }

        public void setHeadName(String headName) {
            this.headName = headName;
        }

        public int getSubstringIndex() {
            return substringIndex;
        }

        public void setSubstringIndex(int substringIndex) {
            this.substringIndex = substringIndex;
        }

        public String getLoginToken() {
            return loginToken;
        }

        public void setLoginToken(String loginToken) {
            this.loginToken = loginToken;
        }
    }
