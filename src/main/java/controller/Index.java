package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index.jsp")
public class Index extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher("inicial.jsp");
		    dispatcher.forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

