package com.example.demo1;

import android.app.AlertDialog;

public class Caller extends Thread{
	
	public CallSoap cs;
	public String EmpId;
	protected AlertDialog ad;
	
	public void run(){
		try{
			cs=new CallSoap();
			String res=cs.Call(EmpId);
			MainActivity.rslt=res;
		}
		catch(Exception e){
			MainActivity.rslt=e.toString();
		}
	}

}
