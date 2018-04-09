package com.qima.college.portal.business;

import java.util.List;

import com.qima.college.portal.vo.CourseSectionVO;

public interface ICourseBusiness {

	/**
	 * 获取课程章节
	 */
	List<CourseSectionVO> queryCourseSection(Long courseId);
	
}
