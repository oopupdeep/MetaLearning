package com.metalearning.content.service;

import com.metalearning.base.model.PageParams;
import com.metalearning.base.model.PageResult;
import com.metalearning.content.model.dto.AddCourseDto;
import com.metalearning.content.model.dto.CourseBaseInfoDto;
import com.metalearning.content.model.dto.QueryCourseParamsDto;
import com.metalearning.content.model.po.CourseBase;

public interface CourseBaseInfoService {
    public PageResult<CourseBase> queryCourseBaseList(PageParams params, QueryCourseParamsDto queryCourseParamsDto);
    CourseBaseInfoDto createCourseBase(Long companyId, AddCourseDto addCourseDto);
    public CourseBaseInfoDto getCourseBaseInfo(long courseId);
}
