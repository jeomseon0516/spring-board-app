package kr.co.sboard.controller;

import kr.co.sboard.dto.AppInfoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@RequiredArgsConstructor
@Controller
public class UserController {

    private final AppInfoDTO appInfo;

    @GetMapping("/user/info")
    public String info(){
        return "user/info";
    }

    @GetMapping("/user/login")
    public String login(){
        return "user/login";
    }

    @GetMapping("/user/register")
    public String register(){
        return "user/register";
    }

    @GetMapping("/user/terms")
    public String terms(){
        return "user/terms";
    }
}