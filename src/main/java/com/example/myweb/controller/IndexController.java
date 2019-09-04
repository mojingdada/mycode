//package com.example.myweb.controller;
//
//import com.example.myweb.Service.MySQLTestService;
//import com.example.myweb.Service.WendaService;
//import com.example.myweb.model.TestModel;
//import com.example.myweb.model.User;
//import org.apache.juli.logging.LogFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.awt.image.IndexColorModel;
//import java.lang.reflect.Array;
//import java.util.*;
//
//import org.springframework.ui.Model;
//import org.springframework.web.servlet.view.RedirectView;
//
//@Controller
//public class IndexController {
//    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
//    @Autowired
//    WendaService wendaService;
//
//    @RequestMapping(path = {"/", "/index"})
//    @ResponseBody
//    public String index(HttpSession httpSession) {
//        logger.info("主页");
//        return wendaService.getMessage(1) + "hello world," + httpSession.getAttribute("msg");
//    }
//
//    @RequestMapping(path = "/profile/{Group}/{UseId}")
//    @ResponseBody
//    public String prfile(@PathVariable("UseId") int UseId,
//                         @PathVariable("Group") String Group,
//                         @RequestParam(value = "Type", defaultValue = "h") String Type,
//                         @RequestParam(value = "Page", defaultValue = "1") int Page) {
//        return String.format("hello %s%d,T:%s,P:%d", Group, UseId, Type, Page);
//    }
//
//    @RequestMapping(path = {"/request"}, method = {RequestMethod.GET})
//    @ResponseBody
//    public String request(Model model,
//                          HttpServletRequest request,
//                          HttpServletResponse response,
//                          HttpSession session,
//                          @CookieValue("JSESSIONID") String sessionId) {
//        StringBuffer sb = new StringBuffer();
//        sb.append("COOKIEVALUE:" + sessionId);
//        Enumeration headname = request.getHeaderNames();
//        while (headname.hasMoreElements()) {
//            String name = (String) headname.nextElement();
//            sb.append(name + ":" + request.getHeader(name) + "<br>");
//        }
//        if (request.getCookies() != null) {
//            for (Cookie cookie : request.getCookies()) {
//                sb.append(cookie.getName() + ":" + cookie.getValue() + "<br>");
//            }
//        }
//        sb.append(request.getMethod() + "<br>");
//        sb.append(request.getRequestURI() + "<br>");
//        response.addHeader("nowcoderId", "hello");
//        response.addCookie(new Cookie("username", "nowcoder"));
//
//        return sb.toString();
//    }
//
////    @RequestMapping(path = {"/vm"}, method = {RequestMethod.GET})
////    public String vm(Model model) {
////        model.addAttribute("value1", "1");
////        model.addAttribute("value2", "2");
////        model.addAttribute("value3", "3");
////        List<String> colors = Arrays.asList(new String[]{"RED", "YELLOW", "BLUE"});
////        model.addAttribute("colors", colors);
////        HashMap map = new HashMap();
////        for (int i = 0; i < 4; i++)
////            map.put(i, i * i);
////        model.addAttribute("map", map);
////        User user = new User("Lee", 18);
////        model.addAttribute("user", user);
////        return "home";
////    }
//
//    @RequestMapping(path = "/redirect/{code}", method = {RequestMethod.GET})
//    @ResponseBody
//    public RedirectView redirect(@PathVariable("code") int code,
//                                 HttpSession httpSession) {
//        httpSession.setAttribute("msg", "jump from redirect");
//        RedirectView red = new RedirectView("/", true);
//        if (code == 301) {
//            red.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
//        }
//        return red;
//    }
//
//    @RestController
//    @Scope("prototype")
//    @RequestMapping("/mysql/test")
//    public class MySQLTestController {
//        @Autowired
//        private MySQLTestService mySQLTestService;
//
//        @PostMapping(value = "/select")
//        public List<TestModel> select() throws Exception {
//            return mySQLTestService.select();
//        }
//
//        @PostMapping(value = "/insert")
//        public int insert(@RequestParam(value = "name") String name) throws Exception {
//            return mySQLTestService.insert(name);
//        }
//    }
//
//    @RequestMapping(path = {"/admin"}, method = {RequestMethod.GET})
//    @ResponseBody
//    public String admin(@RequestParam("key") String key) {
//        if ("admin".equals(key)) {
//            return "hello admin";
//        }
//        throw new IllegalArgumentException("参数不对");
//    }
//
//    @ExceptionHandler()
//    @ResponseBody
//    public String error(Exception e) {
//        return "error:" + e.getMessage();
//    }
//
//
//}
