package com.example.myweb.controller;

import com.example.myweb.Service.UserService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(path = {"/reg"}, method = {RequestMethod.POST})
    public String reg(Model model,
                      @RequestParam("password") String password,
                      @RequestParam("username") String username,
                      @RequestParam("next") String next,
                      boolean rememberme,
                      HttpServletResponse response) {
        try {
            Map map = userService.register(username, password);
            if (map.containsKey("ticket")) {
//                map.get("ticket");
                Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                cookie.setPath("/");
                response.addCookie(cookie);
                if (!StringUtils.isBlank(next)) {
                    return "redirect:" + next;
                }
                return "redirect:/";
            } else {
                model.addAttribute("msg", map.get("msg"));
                return "login";
            }

//            if (map.containsKey("msg")) {
////                model.addAttribute("msg", map.get("msg"));
////                return "login";
////            }
//            return "redirect:/";
        } catch (Exception e) {
            return "login";
        }
    }

    @RequestMapping(path = {"/login"}, method = {RequestMethod.POST})
    public String login(Model model,
                        @RequestParam("password") String password,
                        @RequestParam("username") String username,
                        @RequestParam(value = "next", required = false) String next,
                        boolean rememberme,
                        HttpServletResponse response) {
        try {
            Map map = userService.login(username, password);
            if (map.containsKey("ticket")) {
                Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
                cookie.setPath("/");
                response.addCookie(cookie);
                if (!StringUtils.isBlank(next)) {
                    return "redirect:" + next;
                }
                return "redirect:/";
            } else {
                model.addAttribute("msg", map.get("msg"));
                return "login";
            }
        } catch (Exception e) {
            return "login";
        }
//        return "login";
    }

    @RequestMapping(path = {"/reglogin"}, method = {RequestMethod.GET})
    public String reg(Model model, @RequestParam(value = "next", required = false) String next) {
        model.addAttribute("next", next);
        return "login";
    }

    @RequestMapping(path = {"/logout"}, method = {RequestMethod.GET})
    public String logout(@CookieValue("ticket") String ticket) {
        userService.logout(ticket);
        return "redirect:/";

    }
}
