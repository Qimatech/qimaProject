package com.qima.college.opt.business;

import java.util.List;

import com.qima.college.opt.vo.CourseSectionVO;

public interface ICourseBusiness {

	/**
	 * 获取课程章节
	 */
	List<CourseSectionVO> queryCourseSection(Long courseId);
	
}
