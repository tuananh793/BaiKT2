/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlller;

import dal.DAO;
import entity.Message;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author admin
 */
@WebServlet(name = "create", urlPatterns = {"/create"})
public class create extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user =(User) session.getAttribute("user");
        DAO dao = new DAO();
        List<User> listU = dao.findListUser(user);
        request.setAttribute("listU", listU);
        request.setAttribute("test", "test");
        request.getRequestDispatcher("create.jsp").forward(request, response);       
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String to = request.getParameter("to");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        User user = (User) request.getSession().getAttribute("user");
        DAO dao = new DAO();
        Message message = new Message();
        message.setFrom(user.getUsername());
        message.setTo(to);
        message.setMessagetitle(title);
        message.setMessagecontent(content);        
        dao.saveMessage(message,user);
        response.sendRedirect("inbox");
    }

}
