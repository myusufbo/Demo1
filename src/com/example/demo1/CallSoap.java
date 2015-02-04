package com.example.demo1;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class CallSoap {
	
	public final String SOAP_ACTION = "http://tempuri.org/GetLocalExpense";

	public  final String OPERATION_NAME = "GetLocalExpense"; 

	public  final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";

	public  final String SOAP_ADDRESS = "http://192.168.2.214/TxmsService/MainService.asmx";

	public CallSoap(){
		
	}
	
	@SuppressWarnings("deprecation")
	public String Call(String EmpId){
		
		SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE, OPERATION_NAME);
		PropertyInfo pi = new PropertyInfo();
		pi.setName("EmpId");
		pi.setValue(EmpId);
		pi.setType(String.class);
		request.addProperty(pi);
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet=true;
		
		envelope.setOutputSoapObject(request);
		envelope.encodingStyle= SoapSerializationEnvelope.XSD;
		
		HttpTransportSE httpTransportSE = new HttpTransportSE(SOAP_ADDRESS);
		httpTransportSE.debug=true;
		
		try{
			httpTransportSE.call(SOAP_ACTION, envelope);
			envelope.getResult();
			
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String result=httpTransportSE.responseDump;
		
		return result;
		
	}
	
}