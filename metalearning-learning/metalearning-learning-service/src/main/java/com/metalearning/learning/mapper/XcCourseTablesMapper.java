package com.metalearning.learning.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.metalearning.learning.model.dto.MyCourseTableItemDto;
import com.metalearning.learning.model.dto.MyCourseTableParams;
import com.metalearning.learning.model.po.XcCourseTables;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author itcast
 */
public interface XcCourseTablesMapper extends BaseMapper<XcCourseTables> {

    public List<MyCourseTableItemDto> myCourseTables( MyCourseTableParams params);
    public int myCourseTablesCount( MyCourseTableParams params);

}
