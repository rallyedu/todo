package net.rallyedu.todo.controller;

import net.rallyedu.todo.model.ItemList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemList itemList = new ItemList();
        try {
            String deleteId = req.getParameter("deleteid");
            itemList.delete(Integer.parseInt(deleteId));
        } catch (NumberFormatException e) {
            throw new ServletException("Bad deleteid value submitted.", e);
        }
        resp.sendRedirect("type2");
    }
}
