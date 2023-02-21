package com.metalearning.content.model.dto;

import com.metalearning.content.model.po.CourseCategory;
import lombok.Data;

import java.util.List;

/**
 * @author wang
 * @version 1.0
 * @description TODO
 * @date 2023/2/12 13:54
 */
@Data
public class CourseCategoryTreeDto extends CourseCategory {
    List childrenTreeNodes;
}
