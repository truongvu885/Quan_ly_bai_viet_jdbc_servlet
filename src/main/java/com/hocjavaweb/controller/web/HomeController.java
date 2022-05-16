package com.hocjavaweb.controller.web;

import com.hocjavaweb.model.NewsModel;
import com.hocjavaweb.service.ICategoryService;
import com.hocjavaweb.service.INewService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/trang-chu"})

public class HomeController extends HttpServlet {

    @Inject
    private ICategoryService categoryService;
    @Inject
    private INewService newService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = "Bài viết 6";
        String content = "bài 5";
        Long category_id = 3L;
        NewsModel newsModel = new NewsModel();
        newsModel.setTitle(title);
        newsModel.setContent(content);
        newsModel.setCategory_id(category_id);
        newService.save(newsModel);
        req.setAttribute("categories",categoryService.findAll());
        RequestDispatcher rq = req.getRequestDispatcher("/views/web/home.jsp");
        rq.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
