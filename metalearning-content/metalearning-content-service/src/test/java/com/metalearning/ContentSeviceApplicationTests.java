package com.metalearning;

import com.metalearning.base.model.PageParams;
import com.metalearning.base.model.PageResult;
import com.metalearning.content.mapper.CourseBaseMapper;
import com.metalearning.content.model.dto.CourseCategoryTreeDto;
import com.metalearning.content.model.dto.QueryCourseParamsDto;
import com.metalearning.content.model.po.CourseBase;
import com.metalearning.content.service.CourseBaseInfoService;
import com.metalearning.content.service.CourseCategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author wang
 * @version 1.0
 * @description TODO
 * @date 2023/2/16 13:42
 */
@SpringBootTest
public class ContentSeviceApplicationTests {

    @Autowired
    CourseBaseMapper courseBaseMapper;

    @Autowired
    CourseBaseInfoService courseBaseInfoService;

    @Autowired
    CourseCategoryService courseCategoryService;


    @Test
    void testCourseBaseMapper() {
        CourseBase courseBase = courseBaseMapper.selectById(22);
        Assertions.assertNotNull(courseBase);
    }
    @Test
    void testCourseBaseInfoService() {
        PageParams pageParams = new PageParams();
        PageResult<CourseBase> courseBasePageResult = courseBaseInfoService.queryCourseBaseList(pageParams, new QueryCourseParamsDto());
        System.out.println(courseBasePageResult);
    }
    @Test
    void testCourseCategoryService() {
        List<CourseCategoryTreeDto> courseCategoryTreeDtos = courseCategoryService.queryTreeNodes("1");
        System.out.println(courseCategoryTreeDtos);
    }
}
