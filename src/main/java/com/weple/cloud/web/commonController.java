package com.weple.cloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 반드시 최상위 클래스 바로 위에 붙어야 Spring이 인식합니다!
public class commonController {

    @GetMapping("/weple/common")
    public String wepleCommon() {
        // src/main/resources/templates/weple/common.html 파일을 찾아갑니다.
        return "weple/common"; 
    }
}