package com.javacore.view;
import java.util.List;
import java.util.Scanner;

import com.javacore.controller.BuildingController;
import com.javacore.input.BuildingSearchInput;
import com.javacore.output.BuildingOutput;

public class BuildingListView {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean check = false;
		int choose;
		while(!check) {
			System.out.println("Choose a option: ");
			System.out.println("1. Search building");
			System.out.println("2. Exit");
			choose = sc.nextInt();
			sc.nextLine();
			switch (choose) {
			case 1: 
				System.out.println("Search name: ");
				String name = sc.nextLine();
				System.out.println("Search Floor Area: ");
				Integer floorArea = null;
				try {
					
					floorArea = Integer.parseInt(sc.nextLine());
					break;
				} catch (NumberFormatException e) {
					// TODO: handle exception
				}
				System.out.println("Search Street: ");
				String street = sc.nextLine();
				System.out.println("Search District: ");
				String district = sc.nextLine();
				System.out.println("Search Ward: ");
				String ward = sc.nextLine();
				System.out.println("Search Type: ");
				String type = sc.nextLine();
				BuildingSearchInput buildingSearch = new BuildingSearchInput();
				buildingSearch.setName(name);
				buildingSearch.setFloorArea(floorArea);;
				buildingSearch.setStreet(street);
				buildingSearch.setDistrict(district);
				buildingSearch.setWard(ward);
				buildingSearch.setType(type);
				BuildingController buildingController = new BuildingController();
				List<BuildingOutput> buildings = buildingController.findBuilding(buildingSearch);
				 for (BuildingOutput item : buildings) {
				      System.out.println("Name: " + item.getName());
				      System.out.println("Address: " + item.getAddress());
				      System.out.println("Type: " +item.getType());
				      System.out.println("---------------------------------");
				    }
				 break;
			case 2:
				System.out.println("Exited");
				check = true;
				break;
			default:
				System.out.println("invalid! please choose action in below menu:");
                break;
			} 
		}
		sc.close();
	}
}
