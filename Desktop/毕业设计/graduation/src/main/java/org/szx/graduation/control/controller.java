package org.szx.graduation.control;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.szx.graduation.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.szx.graduation.model.UserLoginInfo;

import javax.validation.Valid;
@Validated
@Controller
public class controller {

    @GetMapping("/register")
    public String register(){
        return "/register.html";
    }
    @PostMapping("/registerverify")
    public String registerverify(@Validated UserLoginInfo userLoginInfo, BindingResult errors){
        if (errors.hasErrors()) {
            // 如果校验不通过，返回用户编辑页面
            return "register";
        }
        // 校验通过，返回成功页面
        return "homepage";
    }
    @GetMapping("/login")
    public String login(){
        return "/login.html";
    }
    @GetMapping("/personalcenter")
    public String personalcenter(){
        return "/personalcenter.html";
    }
    @GetMapping("/changpassword1")
    public String changpassword1(){
        return "/changpassword1.html";
    }
    @GetMapping("/homepage")
    public String homepage(){
        return "/homepage.html";
    }
}
