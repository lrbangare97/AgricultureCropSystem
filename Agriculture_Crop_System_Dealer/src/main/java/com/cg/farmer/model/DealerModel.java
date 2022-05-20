package com.cg.farmer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="DealData")
public class DealerModel
{
	//Attribute
	@Id                 //primary key
	private int dealerId;
	private String dealerAdress;
	private int dContactNo;
	
	//Generate Getter and Setter.......
	
	public int getDealerId() {
		return dealerId;
	}
	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}
	public String getDealerAdress() {
		return dealerAdress;
	}
	public void setDealerAdress(String dealerAdress) {
		this.dealerAdress = dealerAdress;
	}
	public int getdContactNo() {
		return dContactNo;
	}
	public void setdContactNo(int dContactNo) {
		this.dContactNo = dContactNo;
	}
	
	//Generate parameterize  constructor....
	
	public DealerModel(int dealerId, String dealerAdress, int dContactNo) {
		super();
		this.dealerId = dealerId;
		this.dealerAdress = dealerAdress;
		this.dContactNo = dContactNo;
	}
	
	//
	public DealerModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// To String Method..
	@Override
	public String toString() {
		return "DealerModel [dealerId=" + dealerId + ", dealerAdress=" + dealerAdress + ", dContactNo=" + dContactNo
				+ "]";
	}
	
	

}
