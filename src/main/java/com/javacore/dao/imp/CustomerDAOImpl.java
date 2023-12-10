package com.javacore.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javacore.dao.CustomerDAO;
import com.javacore.dao.entity.CustomerEntity;
import com.javacore.utils.ConnectionUtils;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public List<CustomerEntity> findAll() {
		List<CustomerEntity> results = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		// search
		try {
			StringBuilder query = new StringBuilder("select * from customer");
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query.toString());
			while (rs.next()) {
				CustomerEntity customer = new CustomerEntity();
				customer.setFullname(rs.getString("fullname"));
				customer.setPhone(rs.getInt("phone"));
				results.add(customer);
			}
			return results;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return new ArrayList<>();
	}

	@Override
	public void insert(CustomerEntity newCustomer) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// search
		try {
			StringBuilder sql = new StringBuilder("insert into customer(fullname, phone) value(?,?)");
			con = ConnectionUtils.getConnection();
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, newCustomer.getFullname());
			stmt.setInt(2, newCustomer.getPhone());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}