package com.web.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数，文件名称
        String filename = req.getParameter("filename");
        //2.使用字节输入流加载文件到内存
        //2.1 找到服务器路径
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/img/" + filename);
        //2.2 用户字节流读入
        InputStream is = new FileInputStream(realPath);

        //3.设置响应头的打开方式
        resp.setHeader("content-disposition","attachment;filename=" + filename);

        //4.将输入流中的数据写到输出流（借助缓冲）
        ServletOutputStream sos = resp.getOutputStream();
        //缓冲区
        byte[] buffer = new byte[1024 * 8];
        int len;
        while((len = is.read(buff)) !=-1){
            sos.write(buff,0,len);
        }
        sos.close();
        is.close();

    }

    @Override
    protected void doPost(HttpServletRequest req,  HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
