package com.javacore.view;

import java.util.Scanner;

import com.javacore.controller.BuildingController;
import com.javacore.dto.BuildingDTO;

public class BuildingEditView {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean check = false;
		int choose;
		while (!check) {
			System.out.println("Choose a option: ");
			System.out.println("1. Add Building");
			System.out.println("2. Exit");
			choose = sc.nextInt();
			sc.nextLine();
			switch (choose) {
			case 1:
				System.out.println("Input name: ");
				String name = sc.nextLine();
//				System.out.println("Input Floorarea: ");
				Integer floorArea = 21;
//				try {
//					floorArea = Integer.parseInt(sc.nextLine());
//					break;
//				} catch (NumberFormatException e) {
//					// TODO: handle exception
//				}
				System.out.println("Input Street: ");
				String street = sc.nextLine();
				System.out.println("Input Ward: ");
				String ward = sc.nextLine();
				System.out.println("Input District: ");
				String district = sc.nextLine();
				System.out.println("Input rent area: ");
				String rentArea = sc.nextLine();
				BuildingDTO buildingDto = new BuildingDTO();
				buildingDto.setName(name);
				buildingDto.setFloorArea(floorArea);
				buildingDto.setStreet(street);
				buildingDto.setDistrict(district);
				buildingDto.setWard(ward);
				buildingDto.setRentArea(rentArea);
				BuildingController buildingController = new BuildingController();
				buildingController.save(buildingDto);
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
