package com.javacore.abstraction;

public class CaBayMau extends LopCa {

		public String colorEye;
		public String colorSkin;
		public CaBayMau() {}
		public CaBayMau(String cE, String cS, String cEP, String cSP) {
			this.colorEye = cE;
			this.colorSkin= cS;
			super.colorEye = cEP;
			super.colorSkin = cSP;
		}
		public String getColorEye() {
			return colorEye;
		}
		public void setColorEye(String colorEye) {
			this.colorEye = colorEye;
		}
		public String getColorSkin() {
			return colorSkin;
		}
		public void setColorSkin(String colorSkin) {
			this.colorSkin = colorSkin;
		}
		public void boi() {
			System.out.println("Cá bảy màu bơi theo kiểu overriding");
		}
		public void boi(String style) {
			System.out.println(style);
		}
	}


