package com.javacore.abstraction;

public class LopCa {
	public String colorEye;
	public String colorSkin;
	public LopCa() {};
	public LopCa(String cE, String cS) {
		this.colorEye = cE;
		this.colorSkin = cS;
	};
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
		System.out.println("Ca Nao Ma Chang Biet Boi");
	}
	public void boi(String style) {
		System.out.println(style);
	}
	
}
