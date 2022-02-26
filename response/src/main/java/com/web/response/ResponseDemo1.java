package com.web.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//Response响应练习：设置响应头、重定向
@WebServlet(urlPatterns = "/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ResponseDemo1.....");
//        //1.设置状态码为302
//        response.setStatus(302);
//        //2.设置响应头;
//        response.setHeader("location","/responseDemo2");
//        //通过request域传递数据可以实现吗？
//        request.setAttribute("msg","hello response");
//        //简单的写法，重定向，可以跨域
//        //response.sendRedirect("https://www.baidu.com");

        //page-request-session-application
        request.setAttribute("msg","hello response");
        request.getRequestDispatcher("/responseDemo2").forward(request,response);
    }
}
