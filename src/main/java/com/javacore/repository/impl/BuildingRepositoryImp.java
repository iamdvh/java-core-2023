package com.javacore.repository.impl;

import java.util.List;

import com.javacore.constant.SystemConstant;
import com.javacore.repository.BuildingRepository;
import com.javacore.repository.entity.BuildingEntity;
import com.javacore.utils.StringUtils;

public class BuildingRepositoryImp extends SimpleRepository<BuildingEntity> implements BuildingRepository{

	@Override
	public List<BuildingEntity> findBuilding(Integer floorArea, String name, String street, Long districtId, String ward, 
			Integer numberOfBasement, String direction, String level,
			Integer rentAreaFrom, Integer rentAreaTo,Integer rentPriceFrom, Integer rentPriceTo, String type,
			String managerName, String managerPhone, Long staff) {		
		StringBuilder query = new StringBuilder("select  b.* from building b "
				+ "join district d on b.districtid = d.id "
				+ "join rentarea r on b.id = r.buildingid "
				+ "join buildingrenttype t on b.id = t.buildingid "
				+ "join renttype rt on t.renttypeid = rt.id "
				+ "join assignmentbuilding a on a.buildingid = b.id "
				+ ""+SystemConstant.ONE_EQUAL_ONE+"");
		if(!StringUtils.isNullOrEmpty(name)) {
			query.append(" and b.name like'%"+name+"%'");
		}
		if(floorArea != null) {
			query.append(" and b.floorArea like'%"+floorArea+"%'");
		}
		if(!StringUtils.isNullOrEmpty(street)) {
			query.append(" and b.street like'%"+street+"%'");
		}
		if(districtId!= null) {
			query.append(" and districtid like'%"+districtId+"%'");
		}
		if(!StringUtils.isNullOrEmpty(ward)) {
			query.append(" and ward like'%"+ward+"%'");
		}
		if(numberOfBasement != null) {
			query.append(" and numberOfBasement like'%"+numberOfBasement+"%'");
		}
		if(!StringUtils.isNullOrEmpty(direction)) {
			query.append(" and direction like'%"+direction+"%'");
		}
		if(!StringUtils.isNullOrEmpty(level)) {
			query.append(" and level like'%"+level+"%'");
		}
		if(rentAreaFrom != null | rentAreaTo != null) {
			if(rentAreaFrom != null && rentAreaTo != null) {				
				query.append(" and r.value between "+rentAreaFrom+" and "+rentAreaTo+"");
			}else if(rentAreaTo != null){
				query.append(" and r.value >= "+rentAreaTo+"");
			}else if(rentAreaFrom !=null){
				query.append(" and r.value <= "+rentAreaFrom+"");
			}
		}
		if(rentPriceFrom != null | rentPriceTo != null) {
			if(rentPriceFrom != null && rentPriceTo != null) {				
				query.append(" and rentprice between "+rentPriceFrom+" and "+rentPriceTo+"");
			}else if(rentPriceTo == null){
				query.append(" and rentprice >= "+rentPriceFrom+"");
			}else {
				query.append(" and rentprice <= "+rentPriceTo+"");
			}
		}
		if(!StringUtils.isNullOrEmpty(type)) {
			query.append(" and rt.code in("+type+")");
		}
		if(!StringUtils.isNullOrEmpty(managerName)) {
			query.append(" and b.managername like'%"+managerName+"%'");
		}
		if(!StringUtils.isNullOrEmpty(managerPhone)) {
			query.append(" and b.managerphone like'%"+managerPhone+"%'");
		}
		if(staff!=null) {
			query.append(" and a.staffid = "+staff+"");
		}
		query.append(" group by b.id");
		return findByCondition(query.toString());
		}

}
