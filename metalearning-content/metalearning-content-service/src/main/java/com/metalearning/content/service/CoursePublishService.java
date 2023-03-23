package com.metalearning.content.service;

import com.metalearning.content.model.dto.CoursePreviewDto;
import com.metalearning.content.model.po.CoursePublish;

import java.io.File;

public interface CoursePublishService {

    public CoursePreviewDto getCoursePreviewInfo(Long courseId);
    public void commitAudit(Long companyId,Long courseId);

    public void publish(Long companyId,Long courseId);

    public File generateCourseHtml(Long courseId);

    public void  uploadCourseHtml(Long courseId, File file);

    //创建索引
    public Boolean saveCourseIndex(Long courseId) ;

    //进行优化的方法
    public CoursePublish getCoursePublishCache(Long courseId);
}
