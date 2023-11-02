package com.javacore.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.javacore.constant.SystemConstant;
import com.javacore.dao.BuildingDAO;
import com.javacore.dao.anhyeuem.BuildingAnhyeuEm;
import com.javacore.utils.ConnectionUtils;
import com.javacore.utils.StringUtils;

public class BuildingDAOImp implements BuildingDAO{

	@Override
	public BuildingAnhyeuEm[] findBuilding(Integer floorArea, String name, String street, String district, String ward) {
		BuildingAnhyeuEm[] results = new BuildingAnhyeuEm[] {};
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt= null;
		ResultSet rs= null;
		//search
		StringBuilder query = new StringBuilder("select * from buildings "+SystemConstant.ONE_EQUAL_ONE+"");
		// Condition
	if(StringUtils.isNullOrEmpty(name)) {
		query.append(" and name like'%"+name+"%'");
	}
	if(floorArea != null) {
		query.append(" and floorArea like'%"+floorArea+"%'");
	}
	if(StringUtils.isNullOrEmpty(street)) {
		query.append(" and street like'%"+street+"%'");
	}
	if(StringUtils.isNullOrEmpty(district)) {
		query.append(" and district like'%"+district+"%'");
	}
	if(StringUtils.isNullOrEmpty(ward)) {
		query.append(" and ward like'%"+ward+"%'");
	}
		try {			
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query.toString());
			int i = 0;
			while(rs.next()) {
				BuildingAnhyeuEm buildingAnhYeuEm = new BuildingAnhyeuEm();
				buildingAnhYeuEm.setName(rs.getString("name"));
				buildingAnhYeuEm.setStreet(rs.getString("street"));
				buildingAnhYeuEm.setDistrict(rs.getString("district"));
				buildingAnhYeuEm.setWard(rs.getString("ward"));
				buildingAnhYeuEm.setFloorArea(rs.getInt("floorArea"));
				results[i] = buildingAnhYeuEm;
				i++;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			if(con != null) {	
				try {					
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			if(stmt != null) {	
				try {					
					stmt.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			if(rs != null) {
				try {					
					rs.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}	
		return null;
	}

}
