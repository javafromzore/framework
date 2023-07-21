package course.linkflower.link.oneframework.zenofsword.common.vo;

import lombok.Data;

import java.util.Map;

@Data
public class UserSessionVo {
    private Long id;
    private String name;
    private String mail;
    private String account;
    private String phone;
    private Map<String, String> rightsMap;

}
