package com.metalearning.learning.api;

import com.metalearning.base.model.RestResponse;
import com.metalearning.learning.service.LearningService;
import com.metalearning.learning.util.SecurityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description TODO
 * @author Mr.M
 * @date 2022/10/27 8:59
 * @version 1.0
 */
 @Api(value = "学习过程管理接口", tags = "学习过程管理接口")
 @Slf4j
 @RestController
 public class MyLearningController {

  @Autowired
  LearningService learningService;


  @ApiOperation("获取视频")
  @GetMapping("/open/learn/getvideo/{courseId}/{teachplanId}/{mediaId}")
  public RestResponse<String> getvideo(@PathVariable("courseId") Long courseId, @PathVariable("courseId") Long teachplanId, @PathVariable("mediaId") String mediaId) {
   //登录用户
   SecurityUtil.XcUser user = SecurityUtil.getUser();
   String userId = null;
   if(user != null){
    userId = user.getId();
   }
   //获取视频

  return learningService.getVideo(userId,courseId,teachplanId,mediaId);

  }

 }
