package com.demo.p1;

//import com.demo.p2.B1;

public class A1 {
    private int i;
    public A1() {
		
		this.i = 10;
	}
	public A1(int i) {
		super();
		this.i = i;
	}
	
	public void m1() {
		System.out.println("in mymodule1 p1 package "+i);
		//B1 b=new B1();
	}
    
}
