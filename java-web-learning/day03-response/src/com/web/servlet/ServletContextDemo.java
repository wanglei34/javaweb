package com.web.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//获取文件的真实路径（服务器）
@WebServlet(urlPatterns = "/path")
public class ServletContextDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.得到ServletContext对象
        ServletContext context = this.getServletContext();
        //2.web目录资源访问
        String bPath= context.getRealPath("/b.txt");
        System.out.println(bPath);
        //3.web -info目录下的资源访问
        String cPath= context.getRealPath("/WEB-INF/c.txt");
        System.out.println(cPath);
        //4.src目录或子目录下的资源访问
        String aPath = context.getRealPath("/WEB-INF/classes/com/web/servlet/a.txt");
        System.out.println(aPath);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
