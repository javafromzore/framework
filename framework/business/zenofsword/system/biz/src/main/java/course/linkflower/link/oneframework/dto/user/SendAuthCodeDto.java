package course.linkflower.link.oneframework.dto.user;

import lombok.Data;

@Data
public class SendAuthCodeDto {
    private String phone;
    private String email;
    private String userCode;
    private String checkCode;
}
