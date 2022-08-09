package com.hocjavaweb.filter;

import com.hocjavaweb.constant.SystemConstant;
import com.hocjavaweb.model.UserModel;
import com.hocjavaweb.utils.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Authoriazation implements Filter {
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getServletPath();
        //String url = request.getRequestURI();
        if(url.startsWith("/admin")){
            UserModel model = (UserModel) SessionUtil.getInstance().getValue(request,"USERMODEL");
            if(model != null){
                if(model.getRole().getCode().equals(SystemConstant.ADMIN)){
                    filterChain.doFilter(servletRequest,servletResponse);
                }else if(model.getRole().getCode().equals(SystemConstant.USER)){
                    response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_permisson&alert=danger");
                }
            }else {
                response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=not_login&alert=danger");
            }
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
