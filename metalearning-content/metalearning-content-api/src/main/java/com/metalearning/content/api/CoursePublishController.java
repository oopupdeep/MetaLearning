package com.metalearning.content.api;

import com.metalearning.content.model.dto.CoursePreviewDto;
import com.metalearning.content.model.po.CoursePublish;
import com.metalearning.content.service.CoursePublishService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wang
 * @version 1.0
 * @description TODO
 * @date 2023/3/2 15:53
 */
@Controller
public class CoursePublishController {
    @Autowired
    CoursePublishService coursePublishService;

    // 课程预览
    @GetMapping("/coursepreview/{courseId}")
    public ModelAndView preview(@PathVariable("courseId") Long courseId) {

        //查询数据
        CoursePreviewDto coursePreviewInfo = coursePublishService.getCoursePreviewInfo(courseId);


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("model", coursePreviewInfo);
        modelAndView.setViewName("course_template");
        return modelAndView;
    }

    //提交审核
    @ResponseBody
    @PostMapping("/courseaudit/commit/{courseId}")
    public void commitAudit(@PathVariable("courseId") Long courseId) {
        Long companyId = 1232141425L;
        coursePublishService.commitAudit(companyId, courseId);
    }

    @ApiOperation("课程发布")
    @ResponseBody
    @PostMapping("/coursepublish/{courseId}")
    public void coursepublish(@PathVariable("courseId") Long courseId) {

        Long companyId = 1232141425L;
        coursePublishService.publish(companyId,courseId);
    }

//    @ApiOperation("查询课程发布信息")
//    @ResponseBody
//    @GetMapping({"/r/coursepublish/{courseId}"})
//    public CoursePublish getCoursepublish(@PathVariable("courseId") Long courseId) {
//        CoursePublish coursePublish = this.coursePublishService.getCoursePublish(courseId);
//        return coursePublish;
//    }
}
