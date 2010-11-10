package net.rallyedu.todo.controller;

import net.rallyedu.todo.model.ItemList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Type2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemList itemList = new ItemList();
        req.setAttribute("items", itemList.get());
        req.getRequestDispatcher("type2.jsp").forward(req, resp);
    }
}
