package com.widiarifki.rental.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.widiarifki.rental.connection.DBConnectionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;

public class MemberServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {		
		String sql = "INSERT INTO members (name, email, phone, password, date_register, status, device_id) "
			+" VALUES (?, ?, ?, ?, ?, ?, ?)";

		Connection con = DBConnectionHandler.getConnection();

		try {
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String password = req.getParameter("password");
			String device_id = req.getParameter("device_id");

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			if(email == ""){
				ps.setNull(2, java.sql.Types.VARCHAR);
			}else{
				ps.setString(2, email);
			}
			ps.setString(3, phone);
			ps.setString(4, DigestUtils.sha1Hex(password));
			ps.setTimestamp(5, getCurrentTimeStamp());
			ps.setInt(6, 1);
			ps.setString(7, device_id);

			ps.executeUpdate();

			res.setContentType("application/json");
			res.getWriter().println(sql);
			res.getWriter().flush();

        } catch (SQLException e) {
        	res.setContentType("application/json");
			res.getWriter().println(e.getMessage());
			res.getWriter().flush();
        }

	}

	private static Timestamp getCurrentTimeStamp() {
		Date today = new Date();
		return new Timestamp(today.getTime());
	}
}