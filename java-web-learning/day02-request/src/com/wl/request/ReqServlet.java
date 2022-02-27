package com.wl.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/req")
public class ReqServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Protocol:" + request.getProtocol());
        System.out.println("ContextPath:" + request.getContextPath());
        System.out.println("ServletPath:" + request.getServletPath());
        System.out.println("QueryString:" + request.getQueryString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Protocol:" + request.getProtocol());
        System.out.println("ServletPath:" + request.getServletPath());
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("password"));
    }
}
