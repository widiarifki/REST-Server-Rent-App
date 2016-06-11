package com.widiarifki.rental.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

import com.widiarifki.rental.model.Product;
import com.widiarifki.rental.model.ProductCategory;
import com.widiarifki.rental.connection.DBConnectionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		ObjectMapper mapper = new ObjectMapper();

        String sql = "SELECT p.*, pc.name as category_name FROM products p INNER JOIN product_categories pc ON p.id_product_category = pc.id";

        Connection con = DBConnectionHandler.getConnection();
        ArrayList<Product> produkData = new ArrayList<Product>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Product produk = new Product();
				produk.setId(Integer.parseInt(rs.getString("id")));
				produk.setName(rs.getString("name"));
				BigDecimal charge = new BigDecimal(rs.getString("charge"));
				produk.setCharge(charge);
				produk.setChargeBase(Integer.parseInt(rs.getString("charge_base")));
				produk.setDescription(rs.getString("description"));
				produk.setTerms(rs.getString("terms"));

				ProductCategory kategori = new ProductCategory();
				kategori.setId(Integer.parseInt(rs.getString("id_product_category")));
				kategori.setName(rs.getString("category_name"));
				produk.setProductCategory(kategori);

				produkData.add(produk);
			}
        } catch (Exception e) {
            e.printStackTrace();
        }

		String output = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(produkData);
		res.setContentType("application/json");
		res.getWriter().println(output);
		res.getWriter().flush();
	}
}