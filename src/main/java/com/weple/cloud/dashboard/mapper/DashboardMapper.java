package com.weple.cloud.dashboard.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.weple.cloud.history.worklog.service.WorkLogVO;
import com.weple.cloud.project.service.ProjectVO;
import com.weple.cloud.task.service.TaskVO;

@Mapper
public interface DashboardMapper {
    List<TaskVO> selectTasksDueWithinAWeek(@Param("userCode") String userCode);
    
    List<ProjectVO> selectProjectsByMember(@Param("userCode") String userCode);
    
    List<ProjectVO> selectProjectsWithProgress(@Param("userCode") String userCode);
    
    List<WorkLogVO> selectRecentActivities(Map<String, Object> params);
}