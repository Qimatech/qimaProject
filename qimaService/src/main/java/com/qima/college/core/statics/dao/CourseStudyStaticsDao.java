package com.qima.college.core.statics.dao;

import java.util.List;

import com.qima.college.core.statics.domain.CourseStudyStaticsDto;

public interface CourseStudyStaticsDao {
	
	/**
	*统计课程学习情况
	**/
	public List<CourseStudyStaticsDto> queryCourseStudyStatistics(CourseStudyStaticsDto queryEntity);
	
}

