package com.javacore.abstraction;

public class CaChuon extends LopCa{
	public String colorEye;
	public String colorSkin;
	public CaChuon() {}
	public CaChuon(String cE, String cS, String cEP, String cSP) {
		this.colorEye = cE;
		this.colorSkin= cS;
		super.colorEye = cEP;
		super.colorSkin = cSP;
	}
	public String getColorEye() {
		return colorEye;
	}
	public String getColorEyeP() {
		return super.colorEye;
	}
	public void setColorEye(String colorEye) {
		this.colorEye = colorEye;
	}
	public String getColorSkin() {
		return super.colorSkin;
	}
	public String getColorSkinP() {
		return colorSkin;
	}
	public void setColorSkin(String colorSkin) {
		this.colorSkin = colorSkin;
	}
	public void boi() {
		System.out.println("Ca Chuồn Chuồn Bơi");
	}
	
}
