package com.wl.myservlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = {"/res"})
public class HelloServlet extends HttpServlet {
    private String message;

    @Override
    public void init() {
        System.out.println("init...");
        message = "2022北京冬奥会";
    }

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
//        request.getRequestDispatcher("/wl/detail.html").forward(request,response);
//        response.sendRedirect("wl/detail.html");
        String type = request.getParameter("type");
        System.out.println(type);
        switch(type){
            case "html":
                getHtml(response);
                break;
            case "json":
                getJson(response);
                break;
            case "img":
                getImg(request,response);
                break;
            default:
                break;
        }
    }


    private void getHtml(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         out.println("<html lang=\"en\"><body>");
         out.println("<h1>"+message+"</h1>");
         out.println("<img src=\"https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fww4.sinaimg.cn%2Fmw690%2F006Kefbply1gz1ic9r3zij30qo0qo771.jpg&refer=http%3A%2F%2Fwww.sina.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1648038803&t=f36876ef8ee3d4febdce830124d2e8c1\"/>");
         out.println("</body></html>");
         out.flush();
         out.close();
        response.sendRedirect("/wl/detail.html");
}

    public void getJson(HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String json = "{\"name\": \"王磊\",\"age\": \"21\"}";
        out.println(json);
        out.flush();
        out.close();
    }


    private void getImg(HttpServletRequest request,HttpServletResponse response) throws IOException{
        response.setContentType("image/jpeg");
        String path = request.getServletContext().getRealPath("");
        System.out.println(path);
        File file = new File(path+"/img/bdd.JPG");
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = response.getOutputStream();
        while((read = in.read())!=-1){
            out.write(read);
        }
        out.flush();
        out.close();
    }
    @Override
    public void destroy() {
        System.out.println("destoryed...");
    }

}