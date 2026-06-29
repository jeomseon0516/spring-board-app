package kr.co.sboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@RequiredArgsConstructor
@Controller
public class ArticleController {

    @GetMapping("/article/list")
    public String list(){
        return "article/list";
    }

    @GetMapping("/article/modify")
    public String modify(){
        return "article/modify";
    }

    @GetMapping("/article/search")
    public String search(){
        return "article/search";
    }

    @GetMapping("/article/view")
    public String view(){
        return "article/view";
    }

    @GetMapping("/article/write")
    public String write(){
        return "article/write";
    }
}