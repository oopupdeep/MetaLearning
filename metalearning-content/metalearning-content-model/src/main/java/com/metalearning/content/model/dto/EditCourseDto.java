package com.metalearning.content.model.dto;
import com.metalearning.base.exception.ValidationGroups;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wang
 * @version 1.0
 * @description TODO
 * @date 2023/2/17 14:49
 */
@Data
@ApiModel(value="EditCourseDto", description="修改课程基本信息")
public class EditCourseDto extends AddCourseDto {
    @ApiModelProperty(value = "课程名称", required = true)
    private Long id;
}
