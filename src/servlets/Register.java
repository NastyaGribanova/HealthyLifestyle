package servlets;

import services.UserBL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/*
    Страничка регистрации
 */
@WebServlet("/registration")
public class Register extends HttpServlet {

    private UserBL businessLogic = new UserBL();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
           businessLogic.register(request, response);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("login") != null) {
            response.sendRedirect("/profile");
        } else {
            request.getRequestDispatcher("jsp/registrationPage.jsp").forward(request, response);
        }
    }
}
