package com.javacore.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.javacore.constant.SystemConstant;
import com.javacore.dao.BuildingDAO;
import com.javacore.dao.entity.BuildingEntity;
import com.javacore.utils.ConnectionUtils;
import com.javacore.utils.StringUtils;

public class BuildingDAOImp implements BuildingDAO{

	@Override
	public List<BuildingEntity> findBuilding(Integer floorArea, String name, String street, String district, String ward) {
		List<BuildingEntity> results = new ArrayList<BuildingEntity>();
		// TODO Auto-generated method stub
		Connection con = null;
		Statement stmt= null;
		ResultSet rs= null;
		//search
		try {			
		StringBuilder query = new StringBuilder("select * from buildings "+SystemConstant.ONE_EQUAL_ONE+"");
		// Condition
		if(!StringUtils.isNullOrEmpty(name)) {
			query.append(" and name like'%"+name+"%'");
		}
		if(floorArea != null) {
			query.append(" and floorArea like'%"+floorArea+"%'");
		}
		if(!StringUtils.isNullOrEmpty(street)) {
			query.append(" and street like'%"+street+"%'");
		}
		if(!StringUtils.isNullOrEmpty(district)) {
			query.append(" and district like'%"+district+"%'");
		}
		if(!StringUtils.isNullOrEmpty(ward)) {
			query.append(" and ward like'%"+ward+"%'");
		}
		con = ConnectionUtils.getConnection();
		stmt = con.createStatement();
		rs = stmt.executeQuery(query.toString());
		while(rs.next()) {
			BuildingEntity buildingAnhYeuEm = new BuildingEntity();
			buildingAnhYeuEm.setName(rs.getString("name"));
			buildingAnhYeuEm.setStreet(rs.getString("street"));
			buildingAnhYeuEm.setDistrict(rs.getString("district"));
			buildingAnhYeuEm.setWard(rs.getString("ward"));
			buildingAnhYeuEm.setFloorArea(rs.getInt("floorArea"));
			buildingAnhYeuEm.setType(rs.getString("type"));
			results.add(buildingAnhYeuEm);
		}
		return results;
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
		return new ArrayList<>();
		}

	@Override
	public void insert(BuildingEntity buildingEntity, String rentArea) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Long buildingId = null;
		try {
			con = ConnectionUtils.getConnection();
			stmt = con.createStatement();
			con.setAutoCommit(false);
			String sql = "insert into buildings(name, floorArea) values ("+buildingEntity.getName()+"','"+buildingEntity.getFloorArea()+"')";
			int flag = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			rs = stmt.getGeneratedKeys();
			if(flag>0) {				
				while(rs.next()){
					buildingId = rs.getLong(1);
				}
			}
			for(String item : rentArea.split(",")) {				
				String sql1 = "insert into rent_area(value, building_id) values ('"+Integer.parseInt(item)+"','"+buildingId+"')";
				stmt.executeUpdate(sql1);
			}
			con.commit();
		}catch (Exception e) {
			e.printStackTrace();
			try {				
				con.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		finally {
			try {
				con.close();
				stmt.close();
				rs.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
