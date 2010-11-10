package net.rallyedu.todo.controller;

import net.rallyedu.todo.model.ItemList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemList itemList = new ItemList();
        String newItem = req.getParameter("newitem");
        itemList.add(newItem);
        resp.sendRedirect("type2");
    }
}
