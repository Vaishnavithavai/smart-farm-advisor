package com.example.KrishiMitra.dto;

import com.example.KrishiMitra.enums.CropType;
import com.example.KrishiMitra.enums.FarmStage;


public class FarmRequest {

    public CropType getCrop() {
		return crop;
	}

	public void setCrop(CropType crop) {
		this.crop = crop;
	}

	public FarmStage getStage() {
		return stage;
	}

	public void setStage(FarmStage stage) {
		this.stage = stage;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	private CropType crop;

    private FarmStage stage;

    private String city;
}