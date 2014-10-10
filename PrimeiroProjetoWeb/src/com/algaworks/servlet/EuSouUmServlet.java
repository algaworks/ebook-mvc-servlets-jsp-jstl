package com.algaworks.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.exe")
public class EuSouUmServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println(request.getRequestURI());
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Eu sou um Servlet</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
