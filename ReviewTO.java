package com.hcss.bean;

import org.apache.struts.action.ActionForm;
import java.util.Date;



public class ReviewTO extends ActionForm{

	
	private static final long serialVersionUID = 1L;
	private int  did;
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
