package com.metalearning.content.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.metalearning.content.model.dto.CourseCategoryTreeDto;
import com.metalearning.content.model.po.CourseCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 课程分类 Mapper 接口
 * </p>
 *
 * @author itcast
 */

public interface CourseCategoryMapper extends BaseMapper<CourseCategory> {
    public List<CourseCategoryTreeDto> selectTreeNodes(String id);
}
