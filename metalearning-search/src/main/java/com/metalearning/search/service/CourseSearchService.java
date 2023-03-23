package com.metalearning.search.service;

import com.metalearning.base.model.PageParams;
import com.metalearning.base.model.PageResult;
import com.metalearning.search.dto.SearchCourseParamDto;
import com.metalearning.search.dto.SearchPageResultDto;
import com.metalearning.search.po.CourseIndex;

/**
 * @description 课程搜索service
 * @author Mr.M
 * @date 2022/9/24 22:40
 * @version 1.0
 */
public interface CourseSearchService {


    /**
     * @description 搜索课程列表
     * @param pageParams 分页参数
     * @param searchCourseParamDto 搜索条件
     * @return com.metalearning.base.model.PageResult<com.metalearning.search.po.CourseIndex> 课程列表
     * @author Mr.M
     * @date 2022/9/24 22:45
    */
    SearchPageResultDto<CourseIndex> queryCoursePubIndex(PageParams pageParams, SearchCourseParamDto searchCourseParamDto);

 }
