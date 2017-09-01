package com.mark.demo.axis2.client;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.rpc.client.RPCServiceClient;

import com.mark.demo.axis2.server.HelloWorldStub;
import com.mark.demo.axis2.server.SayHello;
import com.mark.demo.axis2.server.SayHelloResponse;

/*
*hxp(huang.xp@topcheer.com)
*2017年9月1日
*
*/
public class SayHelloTest {
	public static void main(String[]args){
		test3();
	}

	public static void test1() {
		try {  
		      // axis1 服务端  
		// String url = "http://localhost:8080/StockQuote/services/StockQuoteServiceSOAP11port?wsdl";  
		      // axis2 服务端  
		      String url = "http://localhost:8080/axis-ws-server/services/helloWorld?wsdl";  
		  
		      // 使用RPC方式调用WebService  
		      RPCServiceClient serviceClient = new RPCServiceClient();  
		      // 指定调用WebService的URL  
		      EndpointReference targetEPR = new EndpointReference(url);  
		      Options options = serviceClient.getOptions();  
		      //确定目标服务地址  
		      options.setTo(targetEPR);  
		      //确定调用方法  
		      options.setAction("urn:sayHello");  
		  
		      /** 
		       * 指定要调用的getPrice方法及WSDL文件的命名空间 
		       * 如果 webservice 服务端由axis2编写 
		       * 命名空间 不一致导致的问题 
		       * org.apache.axis2.AxisFault: java.lang.RuntimeException: Unexpected subelement arg0 
		       */  
		      QName qname = new QName("http://server.axis2.demo.mark.com", "sayHello");  
		      // 指定getPrice方法的参数值  
		      Object[] parameters = new Object[] { "mark" };  
		        
		      // 指定getPrice方法返回值的数据类型的Class对象  
		      Class[] returnTypes = new Class[] { String.class };  
		  
		      // 调用方法一 传递参数，调用服务，获取服务返回结果集  
		      OMElement element = serviceClient.invokeBlocking(qname, parameters);  
		      //值得注意的是，返回结果就是一段由OMElement对象封装的xml字符串。  
		      //我们可以对之灵活应用,下面我取第一个元素值，并打印之。因为调用的方法返回一个结果  
		      String result = element.getFirstElement().getText();  
		      System.out.println(result);  
		  
		      // 调用方法二 getPrice方法并输出该方法的返回值  
		      Object[] response = serviceClient.invokeBlocking(qname, parameters, returnTypes);  
		      // String r = (String) response[0];  
		      String r = (String) response[0];  
		      System.out.println(r);  
		  
		    } catch (AxisFault e) {  
		      e.printStackTrace();  
		    }  
	}
	
	public static void test2() {
		try {  
		      // String url = "http://localhost:8080/axis2ServerDemo/services/StockQuoteService";  
		      String url = "http://localhost:8080/axis-ws-server/services/helloWorld?wsdl";  
		  
		      Options options = new Options();  
		      // 指定调用WebService的URL  
		      EndpointReference targetEPR = new EndpointReference(url);  
		      options.setTo(targetEPR);  
		      // options.setAction("urn:getPrice");  
		  
		      ServiceClient sender = new ServiceClient();  
		      sender.setOptions(options);  
		        
		        
		      OMFactory fac = OMAbstractFactory.getOMFactory();  
		      String tns = "http://server.axis2.demo.mark.com";  
		      // 命名空间，有时命名空间不增加没事，不过最好加上，因为有时有事，你懂的  
		      OMNamespace omNs = fac.createOMNamespace(tns, "");  
		  
		      OMElement method = fac.createOMElement("sayHello", omNs);  
		      OMElement symbol = fac.createOMElement("name", omNs);  
		      // symbol.setText("1");  
		      symbol.addChild(fac.createOMText(symbol, "Axis2 Echo String "));  
		      method.addChild(symbol);  
		      method.build();  
		        
		      OMElement result = sender.sendReceive(method);  
		  
		      System.out.println(result);  
		  
		    } catch (AxisFault axisFault) {  
		      axisFault.printStackTrace();  
		    }  
	}

	public static void test3(){
		try {  
		      String url = "http://localhost:8080/axis-ws-server/services/helloWorld?wsdl";  
		      HelloWorldStub stub = new HelloWorldStub(url);  
		      SayHello request = new SayHello();  
		      request.setName("mark");
		      SayHelloResponse response = stub.sayHello(request);
		      System.out.println(response.get_return());  
		    } catch (org.apache.axis2.AxisFault e) {  
		      e.printStackTrace();  
		    } catch (java.rmi.RemoteException e) {  
		      e.printStackTrace();  
		    }  
	}
}
