package servlets;

import userInterface.UserUI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/addTrainer")
public class AddTrainer extends HttpServlet {

    private UserUI businessLogic = new UserUI();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            businessLogic.addTrainer(request, response);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/trainerRegPage.jsp").forward(request, response);
    }
}
