package course.linkflower.link.system.service;

import course.linkflower.link.oneframework.common.dto.base.IdDto;
import course.linkflower.link.system.vo.privilege.CodeVo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<CodeVo> privilege(IdDto idDto);

    Map<String, String> getUserRights(long userId);
}
