package com.weple.cloud.gantt.service;

public interface GanttService {

	GanttResponseDTO getGanttChartData(Long projectId);

	// [추가] 간트차트 모듈(d6) 권한 체크 메서드 선언
    boolean checkGanttModuleActive(Long projectId);
}
