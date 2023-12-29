package com.javacore.repository.impl;

import java.util.List;
import java.util.Map;

import com.javacore.constant.SystemConstant;
import com.javacore.repository.BuildingRepository;
import com.javacore.repository.entity.BuildingEntity;
import com.javacore.utils.StringUtils;

public class BuildingRepositoryImp extends SimpleRepository<BuildingEntity> implements BuildingRepository {

	@Override
	public List<BuildingEntity> findBuilding(Map<String, Object> buildingSearchInput) {
		
				String join = null;
				String condition = null;
				String noJoin = sqlNoJoin(buildingSearchInput);
				String[] haveJoin = sqlJoin(buildingSearchInput);
				condition = noJoin += haveJoin[1];
				join = haveJoin[0];
				StringBuilder query = new StringBuilder("select  b.* from building b " + join + SystemConstant.ONE_EQUAL_ONE + condition+" group by b.id");
		return findByCondition(query.toString());
	}
	private String[] sqlJoin(Map<String, Object> buildingSearchInput) {
		StringBuilder join = new StringBuilder();
		StringBuilder condition = new StringBuilder();
		if (!StringUtils.isNullOrEmpty((String)buildingSearchInput.get("districtCode"))) {
			join.append("join district d on b.districtid = d.id ");
			condition.append(" and d.code like'%" + (String)buildingSearchInput.get("districtCode") + "%'");
		}
		if (!StringUtils.isNullOrEmpty((String)buildingSearchInput.get("managerName"))) {
			condition.append(" and b.managername like'%" + (String)buildingSearchInput.get("managerName") + "%'");
		}
		if (!StringUtils.isNullOrEmpty((String)buildingSearchInput.get("managerPhone"))) {
			condition.append(" and b.managerphone like'%" + (String)buildingSearchInput.get("managerPhone") + "%'");
		}
		if ((Integer)buildingSearchInput.get("rentAreaFrom") != null | (Integer)buildingSearchInput.get("rentAreaTo") != null) {
			join.append("join rentarea r on b.id = r.buildingid " + "join buildingrenttype t on b.id = t.buildingid ");
			if ((Integer)buildingSearchInput.get("rentAreaFrom") != null && (Integer)buildingSearchInput.get("rentAreaTo") != null) {
				condition.append(" and r.value between " + (Integer)buildingSearchInput.get("rentAreaFrom") + " and " + (Integer)buildingSearchInput.get("rentAreaTo") + "");
			} else if ((Integer)buildingSearchInput.get("rentAreaTo") != null) {
				condition.append(" and r.value <= " + (Integer)buildingSearchInput.get("rentAreaTo") + "");
			} else if ((Integer)buildingSearchInput.get("rentAreaFrom") != null) {
				condition.append(" and r.value >= " + (Integer)buildingSearchInput.get("rentAreaFrom") + "");
			}
		}
		if ((Integer)buildingSearchInput.get("rentPriceFrom") != null | (Integer)buildingSearchInput.get("rentPriceTo") != null) {
			if ((Integer)buildingSearchInput.get("rentPriceFrom") != null && (Integer)buildingSearchInput.get("rentPriceTo") != null) {
				condition.append(" and rentprice between " + (Integer)buildingSearchInput.get("rentPriceFrom") + " and " + (Integer)buildingSearchInput.get("rentPriceTo") + "");
			} else if ((Integer)buildingSearchInput.get("rentPriceTo") == null) {
				condition.append(" and rentprice >= " + (Integer)buildingSearchInput.get("rentPriceFrom") + "");
			} else {
				condition.append(" and rentprice <= " + (Integer)buildingSearchInput.get("rentPriceTo") + "");
			}
		}
		if (!StringUtils.isNullOrEmpty((String)buildingSearchInput.get("type"))) {
			join.append("join buildingrenttype t on t.buildingid = b.id join renttype rt on t.renttypeid = rt.id ");
			condition.append(" and rt.code in(" + (String)buildingSearchInput.get("type") + ")");
		}
		if ((Long)buildingSearchInput.get("staff") != null) {
			join.append("join assignmentbuilding a on a.buildingid = b.id ");
			condition.append(" and a.staffid = " + (Long)buildingSearchInput.get("staff") + "");
		}
		String[] sql = {join.toString(), condition.toString()};
		return sql;
	}
	private String sqlNoJoin(Map<String, Object> buildingSearchInput) {
		StringBuilder condition = new StringBuilder();
		if (!StringUtils.isNullOrEmpty((String)buildingSearchInput.get("name"))) {
			condition.append(" and b.name like'%" + (String)buildingSearchInput.get("name") + "%'");
		}
		if ((Long)buildingSearchInput.get("floorArea") != null) {
			condition.append(" and b.floorArea like'%" + (Long)buildingSearchInput.get("floorArea") + "%'");
		}
		if (!StringUtils.isNullOrEmpty((String)buildingSearchInput.get("street"))) {
			condition.append(" and b.street like'%" + (String)buildingSearchInput.get("street") + "%'");
		}
		if (!StringUtils.isNullOrEmpty((String)buildingSearchInput.get("ward"))) {
			condition.append(" and ward like'%" + (String)buildingSearchInput.get("ward") + "%'");
		}
		if ((Integer)buildingSearchInput.get("numberOfBasement") != null) {
			condition.append(" and numberOfBasement like'%" + (Integer)buildingSearchInput.get("numberOfBasement") + "%'");
		}
		if (!StringUtils.isNullOrEmpty((String)buildingSearchInput.get("direction"))) {
			condition.append(" and direction like'%" + (String)buildingSearchInput.get("direction") + "%'");
		}
		if (!StringUtils.isNullOrEmpty((String)buildingSearchInput.get("level"))) {
			condition.append(" and level like'%" + (String)buildingSearchInput.get("level") + "%'");
		}
		return condition.toString();
	}
	
}
