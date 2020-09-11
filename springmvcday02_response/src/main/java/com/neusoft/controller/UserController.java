package com.neusoft.controller;
import com.neusoft.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
@RequestMapping("/user")
public class UserController {

    // string 响应
    @RequestMapping("/testString")
    public String testString(Model model){
        User user = new User();
        // 假装么 这是调用service查出的结果
        user.setUsername("真好看");
        user.setPassword("123");
        user.setAge(13);
        // model 对象会存储在request中
        model.addAttribute("user", user);
        return "success";
    }
    // void 响应
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid.......");

        // 请求转发去响应 自己调用原生的必须 全路径
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
//        response.sendRedirect(request.getContextPath()+"index.jsp");
        response.sendRedirect(request.getContextPath()+"/index.jsp");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().write("你好完美");

        return;

    }
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("test.......");
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setUsername("真好看");
        user.setPassword("123");
        user.setAge(13);
        mv.addObject("user",user);
        mv.setViewName("success");
        return mv;
    }

}
