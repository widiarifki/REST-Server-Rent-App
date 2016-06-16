package com.widiarifki.rental.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.widiarifki.rental.connection.DBConnectionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MemberServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{

			req.getParameter("name");
			req.getParameter("email");
			req.getParameter("phone");
			req.getParameter("password");

			String strHtml = String.format(
				req.getParameter("name");
			);

			out.println(strHtml);

		}finally{
			out.close();
		}
	}
}