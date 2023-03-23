package com.metalearning.learning.service;

import com.metalearning.base.model.PageResult;
import com.metalearning.learning.model.dto.MyCourseTableParams;
import com.metalearning.learning.model.dto.XcChooseCourseDto;
import com.metalearning.learning.model.dto.XcCourseTablesDto;
import com.metalearning.learning.model.po.XcChooseCourse;
import com.metalearning.learning.model.po.XcCourseTables;

/**
 * @description 我的课程表service
 * @author Mr.M
 * @date 2022/10/25 9:41
 * @version 1.0
 */
public interface MyCourseTablesService {

  /**
   * @description 添加选课
   * @param userId 用户id
   * @param courseId 课程id
   * @return com.metalearning.learning.model.dto.XcChooseCourseDto
   * @author Mr.M
   * @date 2022/10/24 17:33
   */
  public XcChooseCourseDto addChooseCourse(String userId, Long courseId);

  /**
   * @description 判断学习资格
   * @param userId
   * @param courseId
   * @return XcCourseTablesDto 学习资格状态 [{"code":"702001","desc":"正常学习"},{"code":"702002","desc":"没有选课或选课后没有支付"},{"code":"702003","desc":"已过期需要申请续期或重新支付"}]
   * @author Mr.M
   * @date 2022/10/3 7:37
   */
  public XcCourseTablesDto getLeanringStatus(String userId, Long courseId);

  /**
   * @description 添加我的课程表
   * @param xcChooseCourse
   * @return com.metalearning.learning.model.po.XcCourseTables
   * @author Mr.M
   * @date 2022/10/26 11:35
  */
  public XcCourseTables addCourseTabls(XcChooseCourse xcChooseCourse);

  /**
   * @description 我的课程表
   * @param params
   * @return com.metalearning.base.model.PageResult<com.metalearning.learning.model.po.XcCourseTables>
   * @author Mr.M
   * @date 2022/10/27 9:24
  */
  public PageResult<XcCourseTables> mycourestabls(MyCourseTableParams params);

}
