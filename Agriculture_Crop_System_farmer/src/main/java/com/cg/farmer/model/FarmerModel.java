package com.cg.farmer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="FarmData")

// model class ....pojo class...
public class FarmerModel
{
	//Attribute
	@Id
	private int farmerId;
	private String farmerAdress;
	private int fContactNo;
	private int price;
	private String crops;
	public int getFarmerId() {
		return farmerId;
	}
	// create getter and setter method............
	public void setFarmerId(int farmerId) {
		this.farmerId = farmerId;
	}
	public String getFarmerAdress() {
		return farmerAdress;
	}
	public void setFarmerAdress(String farmerAdress) {
		this.farmerAdress = farmerAdress;
	}
	public int getfContactNo() {
		return fContactNo;
	}
	public void setfContactNo(int fContactNo) {
		this.fContactNo = fContactNo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCrops() {
		return crops;
	}
	public void setCrops(String crops) {
		this.crops = crops;
	}
	//Parameterize Constructor ................... 
	public FarmerModel(int farmerId, String farmerAdress, int fContactNo, int price, String crops) {
		super();
		this.farmerId = farmerId;
		this.farmerAdress = farmerAdress;
		this.fContactNo = fContactNo;
		this.price = price;
		this.crops = crops;
	}
	//Default Constructor.............................
	public FarmerModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	 // To string method 
	
	@Override
	public String toString() {
		return "farmerModel [farmerId=" + farmerId + ", farmerAdress=" + farmerAdress + ", fContactNo=" + fContactNo
				+ ", price=" + price + ", crops=" + crops + "]";
	}
	
	
	

}
