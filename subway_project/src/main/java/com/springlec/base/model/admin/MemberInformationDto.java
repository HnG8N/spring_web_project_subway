package com.springlec.base.model.admin;

public class MemberInformationDto {
	
	// Field
	String mid; 
	String mpw; 
	String mname; 
	String maddress; 
	String mtel; 
	String mbirth; 
	String memail; 
	String mregdate; 
	String menddate;
	
	// Constructor
	public MemberInformationDto() {
	}
	
	// Method
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMaddress() {
		return maddress;
	}
	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}
	public String getMtel() {
		return mtel;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	public String getMbirth() {
		return mbirth;
	}
	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMregdate() {
		return mregdate;
	}
	public void setMregdate(String mregdate) {
		this.mregdate = mregdate;
	}
	public String getMenddate() {
		return menddate;
	}
	public void setMenddate(String menddate) {
		this.menddate = menddate;
	}

}
