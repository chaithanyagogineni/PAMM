package com.hcss.bean;

import org.apache.struts.action.ActionForm;




public class DrugsTo extends ActionForm{
	
	
	
	private int  did;
	private String drugName;
	private String brandName;
	private String usage;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	
	
	
	
	
}
