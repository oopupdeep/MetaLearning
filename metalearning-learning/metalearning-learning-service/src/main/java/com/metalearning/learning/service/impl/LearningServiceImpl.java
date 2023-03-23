package com.metalearning.learning.service.impl;

import com.metalearning.learning.feignclient.ContentServiceClient;
import com.metalearning.learning.feignclient.MediaServiceClient;
import com.metalearning.learning.service.LearningService;
import com.metalearning.learning.service.MyCourseTablesService;
import com.metalearning.base.exception.MetalearningException;
import com.metalearning.base.model.RestResponse;
import com.metalearning.content.model.po.CoursePublish;
import com.metalearning.learning.model.dto.XcCourseTablesDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mr.M
 * @version 1.0
 * @description TODO
 * @date 2022/10/27 9:01
 */
@Slf4j
@Service
public class LearningServiceImpl implements LearningService {

    @Autowired
    MyCourseTablesService myCourseTablesService;
    @Autowired
    MediaServiceClient mediaServiceClient;
    @Autowired
    ContentServiceClient contentServiceClient;


    @Override
    public RestResponse<String> getVideo(String userId, Long courseId, Long teachplanId, String mediaId) {
        //查询课程
        CoursePublish coursepublish = contentServiceClient.getCoursepublish(courseId);
        if(coursepublish==null){
            MetalearningException.cast("课程信息不存在");
        }
        //用户已经登录
        if(StringUtils.isNotEmpty(userId)){
            //获取学习资格
            XcCourseTablesDto leanringStatus = myCourseTablesService.getLeanringStatus(userId, courseId);
            //学习资格，[{"code":"702001","desc":"正常学习"},{"code":"702002","desc":"没有选课或选课后没有支付"},{"code":"702003","desc":"已过期需要申请续期或重新支付"}]
            String learnStatus = leanringStatus.getLearnStatus();
            if(learnStatus.equals("702001")){
                //远程调用媒资获取视频播放地址
                RestResponse<String> playUrlByMediaId = mediaServiceClient.getPlayUrlByMediaId(mediaId);
                return playUrlByMediaId;
            }else if(learnStatus.equals("702003")){
                RestResponse.validfail("您的选课已过期需要申请续期或重新支付");
            }
        }

        //用户未登录
        //该课程是否免费，如果免费可以继续学习
        String charge = coursepublish.getCharge();//收费规则
        if("201000".equals(charge)){
            return mediaServiceClient.getPlayUrlByMediaId(mediaId);
        }


        return RestResponse.validfail("请购买课程后继续学习");
    }
}
