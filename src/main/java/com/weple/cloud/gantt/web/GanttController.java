package com.weple.cloud.gantt.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weple.cloud.gantt.service.GanttService;
import com.weple.cloud.project.service.ProjectService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/project/gantt")
public class GanttController {

    private final ProjectService projectService;
    private final GanttService ganttService; // [추가] 간트 권한 체크를 위한 서비스 주입

    // 간트차트 화면 조회
    @GetMapping
    public String ganttChart(@RequestParam Long projectId, Model model) {
        
        // [추가] 모듈 맵핑 권한 체크 (d6 모듈 활성화 여부 확인)
        if (!ganttService.checkGanttModuleActive(projectId)) {
            model.addAttribute("accessDenideTitle", "접근 권한이 없습니다.");
            model.addAttribute("accessDenideMessage", "해당 프로젝트의 간트차트(d6) 모듈이 비활성화 상태입니다. 관리자에게 문의하세요.");
            return "weple/access-denide";
        }
        
        // 기존 툴바/사이드바 UI 유지를 위한 속성 세팅
        model.addAttribute("currentMenu", "gantt");
        model.addAttribute("sidebarMenu", "project");
        model.addAttribute("projectId", projectId);
        model.addAttribute("project", projectService.findById(String.valueOf(projectId)));
        
        // 알맞은 뷰 경로 리턴
        return "weple/gantt/chart"; 
    }
}
