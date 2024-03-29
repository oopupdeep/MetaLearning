package com.metalearning.learning.api;

import com.metalearning.learning.util.SecurityUtil;
import com.metalearning.base.exception.MetalearningException;
import com.metalearning.base.model.PageResult;
import com.metalearning.learning.model.dto.MyCourseTableParams;
import com.metalearning.learning.model.dto.XcChooseCourseDto;
import com.metalearning.learning.model.dto.XcCourseTablesDto;
import com.metalearning.learning.model.po.XcCourseTables;
import com.metalearning.learning.service.MyCourseTablesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 我的课程表接口
 * @author Mr.M
 * @date 2022/10/25 9:40
 * @version 1.0
 */

 @Api(value = "我的课程表接口", tags = "我的课程表接口")
 @Slf4j
 @RestController
 public class MyCourseTablesController {

  @Autowired
 MyCourseTablesService myCourseTablesService;


  @ApiOperation("添加选课")
  @PostMapping("/choosecourse/{courseId}")
  public XcChooseCourseDto addChooseCourse(@PathVariable("courseId") Long courseId)  {
    //当前登录用户
    SecurityUtil.XcUser user = SecurityUtil.getUser();
    //用户id
    String userId = user.getId();
   //调用service添加选课
   XcChooseCourseDto xcChooseCourseDto = myCourseTablesService.addChooseCourse(userId, courseId);

   return xcChooseCourseDto;
  }

 @ApiOperation("查询学习资格")
 @PostMapping("/choosecourse/learnstatus/{courseId}")
 public XcCourseTablesDto getLearnstatus(@PathVariable("courseId") Long courseId) {
  //登录用户
  SecurityUtil.XcUser user = SecurityUtil.getUser();
  if(user == null){
   MetalearningException.cast("请登录后继续选课");
  }
  String userId = user.getId();
  return  myCourseTablesService.getLeanringStatus(userId, courseId);

 }

 @ApiOperation("我的课程表")
 @GetMapping("/mycoursetable")
 public PageResult<XcCourseTables> mycoursetable(MyCourseTableParams params) {
  //登录用户
  SecurityUtil.XcUser user = SecurityUtil.getUser();
  if(user == null){
   MetalearningException.cast("请登录后继续选课");
  }
  String userId = user.getId();
 //设置当前的登录用户
  params.setUserId(userId);

   return myCourseTablesService.mycourestabls(params);
 }

 }
