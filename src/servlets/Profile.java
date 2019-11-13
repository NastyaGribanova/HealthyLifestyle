package servlets;

import userInterface.UserUI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/*
    Страничка профиля
 */
@WebServlet("/profile")
public class Profile extends HttpServlet {

    private UserUI businessLogic = new UserUI();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            businessLogic.profile(request, response);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            if (request.getSession().getAttribute("user") == null) {
                response.sendRedirect("/login");
            } else {
                request.getRequestDispatcher("jsp/profilePage.jsp").forward(request, response);
            }
        }
    }
}
