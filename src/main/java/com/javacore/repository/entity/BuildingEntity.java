package com.javacore.repository.entity;

import com.javacore.annotation.Column;
import com.javacore.annotation.Entity;
import com.javacore.annotation.Table;
@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity{
	@Column(name = "name")
	private String name;
	@Column(name = "floorarea")
	private Integer floorArea;
	@Column(name = "street")
	private String street;
	@Column(name = "ward")
	private String ward;
	@Column(name = "districtid")
	private Long districtId;
	@Column(name = "rentprice")
	private Integer rentPrice;
	
	public Integer getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Integer rentPrice) {
		this.rentPrice = rentPrice;
	}
	public Long getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Integer floorArea) {
		this.floorArea = floorArea;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
}
