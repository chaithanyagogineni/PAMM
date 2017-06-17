package com.hcss.bean;

import java.util.Date;

public class ReviewBean {

	private static final long serialVersionUID = 1L;
	private int  did;
	private float  k3;
	private float  k5;
	private float  k10;
	private float  k15;
	private float  k20;
	private String algorithm;
	public float getK3() {
		return k3;
	}
	public void setK3(float k3) {
		this.k3 = k3;
	}
	public float getK5() {
		return k5;
	}
	public void setK5(float k5) {
		this.k5 = k5;
	}
	public float getK10() {
		return k10;
	}
	public void setK10(float k10) {
		this.k10 = k10;
	}
	public float getK15() {
		return k15;
	}
	public void setK15(float k15) {
		this.k15 = k15;
	}
	public float getK20() {
		return k20;
	}
	public void setK20(float k20) {
		this.k20 = k20;
	}
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	private int  rid;
	private int  rating;
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

	private String drugName;
	private String username;
	private int useridref;
	public int getRid() {
		return rid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	private String review;
	private String ageten;
	private String agetwenty;
	private String agetethy;
	private String agefourty;
	private String agefifty;
	private String agesixty;
	
	
	public String getAgeten() {
		return ageten;
	}
	public void setAgeten(String ageten) {
		this.ageten = ageten;
	}
	public String getAgetwenty() {
		return agetwenty;
	}
	public void setAgetwenty(String agetwenty) {
		this.agetwenty = agetwenty;
	}
	public String getAgetethy() {
		return agetethy;
	}
	public void setAgetethy(String agetethy) {
		this.agetethy = agetethy;
	}
	public String getAgefourty() {
		return agefourty;
	}
	public void setAgefourty(String agefourty) {
		this.agefourty = agefourty;
	}
	public String getAgefifty() {
		return agefifty;
	}
	public void setAgefifty(String agefifty) {
		this.agefifty = agefifty;
	}
	public String getAgesixty() {
		return agesixty;
	}
	public void setAgesixty(String agesixty) {
		this.agesixty = agesixty;
	}
	public int getUseridref() {
		return useridref;
	}
	public void setUseridref(int useridref) {
		this.useridref = useridref;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private Date rdate;
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
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
	

}
