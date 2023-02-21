package com.metalearning.content.api;

import com.metalearning.base.model.PageParams;
import com.metalearning.base.model.PageResult;
import com.metalearning.content.model.dto.AddCourseDto;
import com.metalearning.content.model.dto.CourseBaseInfoDto;
import com.metalearning.content.model.dto.EditCourseDto;
import com.metalearning.content.model.dto.QueryCourseParamsDto;
import com.metalearning.content.model.po.CourseBase;
import com.metalearning.content.service.CourseBaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author wang
 * @version 1.0
 * @description 课程信息编辑接口，pageParams分页参数通过url的key/value传入，queryCourseParams通过json数据传入，使用@RequestBody注解将json转成QueryCourseParamsDto对象。
 * @date 2023/2/11 20:03
 */
@Api(value = "课程信息编辑接口", tags = "课程信息编辑接口")
@RestController //将返回对象转成json
public class CourseBaseInfoController {

    @Autowired
    CourseBaseInfoService courseBaseInfoService;

    @ApiOperation("课程查询接口")
    @PostMapping("/course/list")
    public PageResult<CourseBase> list(PageParams pageParams, @RequestBody QueryCourseParamsDto queryCourseParamsDto) {
        PageResult<CourseBase> courseBasePageResult = courseBaseInfoService.queryCourseBaseList(pageParams, queryCourseParamsDto);
        return courseBasePageResult;
    }

    @ApiOperation("新增课程基础信息")
    @PostMapping("/course")
    public CourseBaseInfoDto createCourseBase(@RequestBody @Validated AddCourseDto
                                                      addCourseDto) {
        //获取当前用户所属培训机构的id
        Long companyId = 22L;

        //调用service
        CourseBaseInfoDto courseBase = courseBaseInfoService.createCourseBase(companyId, addCourseDto);
        return null;
    }

    @ApiOperation("根据课程id查询课程基础信息")
    @GetMapping("/course/{courseId}")
    public CourseBaseInfoDto getCourseBaseById(@PathVariable Long courseId){
        return null;
    }

//    @ApiOperation("修改课程基础信息")
//    @PutMapping("/course")
//    public CourseBaseInfoDto modifyCourseBase(@RequestBody @Validated EditCourseDto
//                                                         editCourseDto){
//    }
}
