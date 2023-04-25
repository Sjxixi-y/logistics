package com.sjxixi.logistics.controller;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证码生成
 */

@WebServlet("/code")
public class CodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.生成验证码对象
        //int width, int height, int codeCount, int lineCount
        ValidateCode validateCode = new ValidateCode(80,30,5,50);
        //2.将验证码放入到session
        String code = validateCode.getCode();
        System.out.println("code = "+code);
        req.getSession().setAttribute("code",code);
        //3 向页面写回验证码
        ServletOutputStream outputStream = resp.getOutputStream();
        validateCode.write(outputStream);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
