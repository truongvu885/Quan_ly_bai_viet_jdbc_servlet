package com.hocjavaweb.controller.web;

import com.hocjavaweb.model.UserModel;
import com.hocjavaweb.service.ICategoryService;
import com.hocjavaweb.service.INewService;
import com.hocjavaweb.service.IUserService;
import com.hocjavaweb.utils.FormUtil;
import com.hocjavaweb.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/trang-chu","/dang-nhap","/thoat"})

public class HomeController extends HttpServlet {

    @Inject
    private ICategoryService categoryService;

    @Inject
    private INewService newService;

    @Inject
    private IUserService userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setAttribute("categories",categoryService.findAll());
        //req.setAttribute("news", newService.findByCategoryId(4L));
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
        String action = req.getParameter("action");
        if(action!=null && action.equals("login")){
            String message = req.getParameter("message");
            String alert = req.getParameter("alert");
            if(message != null && alert !=null){
                req.setAttribute("message",resourceBundle.getString(message));
                req.setAttribute("alert",alert);
            }
            RequestDispatcher rq = req.getRequestDispatcher("/views/login.jsp");
            rq.forward(req,resp);
        }
        else if(action!=null && action.equals("logout")){
            SessionUtil.getInstance().removeValue(req,"USERMODEL");
            resp.sendRedirect(req.getContextPath()+"/trang-chu");
        }
        else {
            RequestDispatcher rq = req.getRequestDispatcher("/views/web/home.jsp");
            rq.forward(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action!=null && action.equals("login")){
            UserModel model = FormUtil.toModel(UserModel.class,req);
            model = userService.findByUserNameAndPasswordAndStatus(model.getUserName(),model.getPassWord(),1);
            if(model != null){
                SessionUtil.getInstance().pushValue(req,"USERMODEL",model);
                if(model.getRole().getCode().equals("USER")){
                    resp.sendRedirect(req.getContextPath()+"/trang-chu");
                }else if(model.getRole().getCode().equals("ADMIN")){
                    resp.sendRedirect(req.getContextPath()+"/admin-home");
                }
            }else {
                resp.sendRedirect(req.getContextPath()+"/dang-nhap?action=login&message=username_password_invalid&alert=danger");
            }
        }
    }
}
