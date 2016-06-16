package com.widiarifki.rental.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;i
import java.util.Formatter;
import java.util.Date;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.widiarifki.rental.connection.DBConnectionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MemberServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String sql = "INSERT INTO members (name, email, phone, password, date_register) "
			+" VALUES (?, ?, ?, ?, ?)";

		Connection con = DBConnectionHandler.getConnection();

		try {
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String password = req.getParameter("password");

			MessageDigest sha1 = MessageDigest.getInstance("SHA1");

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phone);
			ps.setString(4, calculateHash(sha1, email));
			ps.setTimestamp(5, getCurrentTimeStamp());

			ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	private static Timestamp getCurrentTimeStamp() {
		Date today = new Date();
		return new Timestamp(today.getTime());
	}

	public static String calculateHash(MessageDigest algorithm, String message) throws Exception{
		algorithm.update(message.getBytes());
		byte[] hash = algorithm.digest();
		return byteArray2Hex(hash);
    }

    private static String byteArray2Hex(byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }
}