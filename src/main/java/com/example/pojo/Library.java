package com.example.pojo;

public class Library {
	private String bid;
	private String bname;
	private String bauthor;
	private String bprice;
	private String byear;
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBprice() {
		return bprice;
	}
	public void setBprice(String bprice) {
		this.bprice = bprice;
	}
	public String getByear() {
		return byear;
	}
	public void setByear(String byear) {
		this.byear = byear;
	}
	@Override
	public String toString() {
		return "Library [bid=" + bid + ", bname=" + bname + ", bauthor=" + bauthor + ", bprice=" + bprice + ", byear="
				+ byear + "]";
	}
	
	
	

}
