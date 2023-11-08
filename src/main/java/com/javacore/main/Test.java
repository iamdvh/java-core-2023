package com.javacore.main;

import com.javacore.abstraction.CaBayMau;
import com.javacore.abstraction.CaChuon;
import com.javacore.abstraction.LopCa;

public class Test {
	public static void main(String[] args) {
		CaChuon caChuon = new CaChuon("Black", "Yellow", "Red", "Blue");
		System.out.println("Màu mắt cá chuồn: " +caChuon.getColorEye());
		System.out.println("Màu da cá chuồn: " +caChuon.getColorSkin());
		System.out.println("Màu mắt cá chuồn mẹ: " + caChuon.getColorEyeP());
		System.out.println("Màu da cá chuồn mẹ: " +caChuon.getColorSkinP());
		LopCa caBayMau = new CaBayMau();
		caBayMau.boi();
		caBayMau.boi("Cá bảy màu bơi theo kiểu overloading");
	}
}
