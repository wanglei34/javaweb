package com.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book[] books = {
                new Book("红楼梦", "红楼梦.JPG", "曹雪芹"),
                new Book("西游记", "西游记.JPG", "吴承恩"),
                new Book("三国演义", "三国演义.JPG", "罗贯中"),
        };
        List<Book> bookList = Arrays.asList(books);
        req.setAttribute("bookList", bookList);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
