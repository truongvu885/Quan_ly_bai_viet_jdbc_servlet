package com.hocjavaweb.controller.admin.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hocjavaweb.model.NewsModel;
import com.hocjavaweb.service.INewService;
import com.hocjavaweb.utils.HttpUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-new"})

public class NewAPI extends HttpServlet {
    @Inject
    private INewService newService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        NewsModel newsModel =  HttpUtil.of(req.getReader()).toModel(NewsModel.class);
        newsModel = newService.save(newsModel);
        mapper.writeValue(resp.getOutputStream(),newsModel);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        NewsModel updateNewsModel =  HttpUtil.of(req.getReader()).toModel(NewsModel.class);
        updateNewsModel = newService.update(updateNewsModel);
        mapper.writeValue(resp.getOutputStream(),updateNewsModel);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        NewsModel deleteNewsModel =  HttpUtil.of(req.getReader()).toModel(NewsModel.class);
        newService.delete(deleteNewsModel.getIds());
        mapper.writeValue(resp.getOutputStream(),"{ }");
    }
}
