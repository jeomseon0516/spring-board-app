package kr.co.sboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@RequiredArgsConstructor
@Controller
public class FindController {

    @GetMapping("/find/changePassword")
    public String changePassword(){
        return "find/changePassword";
    }

    @GetMapping("/find/password")
    public String password(){
        return "find/password";
    }

    @GetMapping("/find/resultUserid")
    public String resultUserid(){
        return "find/resultUserid";
    }

    @GetMapping("/find/userid")
    public String userid(){
        return "find/userid";
    }

}