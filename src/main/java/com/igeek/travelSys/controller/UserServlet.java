package com.igeek.travelSys.controller;



import com.igeek.travelSys.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;


/**
 * @author qiankun
 * @create 2021/6/6
 */
@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BasicServlet{

    private UserService userService=new UserService();


    //登录
   public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


       //获得jsp表单中的请求参数
       String username = request.getParameter("username");
       String password=request.getParameter("password");

       //登录验证
       boolean flag = userService.login(username, password);

       if(flag){
           //登陆成功
           request.setAttribute("msg","恭喜您登陆成功！");
           request.getRequestDispatcher("index.jsp").forward(request,response);
       }else{
           //登陆失败
           request.setAttribute("msg","登陆失败，请重新输入信息！");
           request.getRequestDispatcher("login.jsp").forward(request,response);
       }

   }

}
