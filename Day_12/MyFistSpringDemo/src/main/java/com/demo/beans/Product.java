package com.demo.beans;

public class Product {
	private int pid;
	private String pname;
	private int qty;
	public Product() {
		super();
		System.out.println("in product default constructor");
	}
	public Product(int pid, String pname, int qty) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.qty = qty;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		System.out.println("in setpid");
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		System.out.println("in setpname");
		this.pname = pname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		System.out.println("in setqty");
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", qty=" + qty + "]";
	}
	

}
