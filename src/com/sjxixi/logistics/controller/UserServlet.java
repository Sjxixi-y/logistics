package com.sjxixi.logistics.controller;

import com.sjxixi.logistics.entity.Admin;
import com.sjxixi.logistics.service.IAdminService;
import com.sjxixi.logistics.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private static final IAdminService ias = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("judge".equals(action)) {
            // 判断用户是否存在
            judge(req, resp);
        } else if ("register".equals(action)) {
            // 注册
            register(req, resp);
        } else if ("login".equals(action)) {
            // 登录
            login(req, resp);
        } else if ("exit".equals(action)) {
            // 退出
            exit(req, resp);
        } else if ("find".equals(action)) {
            // 查询全部
            query(req, resp);
        } else if ("del".equals(action)) {
            // 删除
            del(req, resp);
        } else if ("findById".equals(action)) {
            // 修改
            findById(req, resp);
        } else if ("upd".equals(action)) {
            // 更新
            update(req, resp);
        }
    }

    /**
     * 查询是否存在这个用户
     *
     * @param req  请求
     * @param resp 响应
     */
    private void judge(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String name = req.getParameter("name");
            Admin qry = ias.qry(name, 1);
            String flog = "0";
            if (qry != null) {
                flog = "1";
            }
            PrintWriter writer = resp.getWriter();
            writer.write(flog);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 注册
     *
     * @param req  请求
     * @param resp 响应
     */
    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Admin admin = new Admin(username, password);

        ias.register(admin);

        // 重定向 至登录
        resp.sendRedirect("login.html");
    }

    /**
     * 登录
     *
     * @param req  请求
     * @param resp 响应
     */
    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Admin admin = ias.qry(username, password);

        if (admin != null) {
            // 保存数据
            HttpSession session = req.getSession();
            session.setAttribute("admin", admin);
            // 设置 Cookie 时间
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(60 * 30);
            resp.addCookie(cookie);
            // 重定向至主页
            resp.sendRedirect(req.getContextPath() + "/index.html");
        } else {
            // 登录失败
            String msg = "登录失败，请尝试重新登录";
            req.setAttribute("msg", msg);
            // 转发
            req.getRequestDispatcher("login.html").forward(req, resp);
        }
    }

    private void exit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.removeAttribute("admin");
        }
        resp.sendRedirect("login.html");
    }

    private void query(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void del(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void findById(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
