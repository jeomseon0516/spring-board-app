package kr.co.sboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.dto.TermsDTO;
import kr.co.sboard.dto.UserCheckDTO;
import kr.co.sboard.dto.UserDTO;
import kr.co.sboard.service.TermsService;
import kr.co.sboard.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@Controller
public class UserController {

    private final TermsService termsService;
    private final UserService userService;

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

    @PostMapping("/user/register")
    public String register(UserDTO dto, HttpServletRequest req) {
        String regip = req.getRemoteAddr();
        dto.setRegip(regip);

        log.info(dto);

        // 등록 서비스 호출
        userService.register(dto);

        return "redirect:/user/login?register=success";
    }

    @GetMapping("/user/terms")
    public String terms(Model model){
        TermsDTO termsDTO = termsService.get(1);
        log.info("termsDTO : {}", termsDTO);

        model.addAttribute("termsDTO", termsDTO);
        // 약관 조회 서비스 호출
        return "user/terms";
    }

    @ResponseBody
    @GetMapping("/user/check")
    public ResponseEntity<Map<String, Integer>> check(UserCheckDTO dto) {
        log.info(dto);

        // 서비스 호출
        int count = userService.getCount(dto);

        return ResponseEntity.ok(Map.of("count", count));
    }

    @ResponseBody
    @PostMapping("/user/check")
    public ResponseEntity<Map<String, Integer>> check(@RequestBody Map<String, String> jsonData) {
        log.info(jsonData);

        int count = 0;

        return ResponseEntity.ok(Map.of("count", count));
    }
}