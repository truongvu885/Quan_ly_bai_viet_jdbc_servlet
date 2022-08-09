package com.hocjavaweb.controller.admin;

import com.hocjavaweb.constant.SystemConstant;
import com.hocjavaweb.model.NewsModel;
import com.hocjavaweb.paging.PageRequest;
import com.hocjavaweb.paging.Pageble;
import com.hocjavaweb.service.INewService;
import com.hocjavaweb.sort.Sorter;
import com.hocjavaweb.utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-new"})

public class NewController extends HttpServlet {

    @Inject
    private INewService newService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsModel model = FormUtil.toModel(NewsModel.class,req);
        Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
                new Sorter(model.getSortName(),model.getSortBy()));

        model.setListResult(newService.findAll(pageble));
        model.setTotalItems(newService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItems() / model.getMaxPageItem()));

        req.setAttribute(SystemConstant.MODEL,model);
        RequestDispatcher rq = req.getRequestDispatcher("/views/admin/new/list.jsp");
        rq.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
