package course.linkflower.link.oneframework.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class BaseDto implements Serializable {

    private String id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:m:ss",timezone = "GMT+8")
    private Date createDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:m:ss",timezone = "GMT+8")
    private Date updateDate;
}
