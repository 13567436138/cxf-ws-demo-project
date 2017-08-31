package com.mark.demo.client;

import com.mark.demo.OrderWebServiceI;
import com.mark.demo.OrderWebServiceImplService;

/*
*hxp(huang.xp@topcheer.com)
*2017年8月31日
*
*/
public class Client {
	public static void main(String args[]) {
		OrderWebServiceImplService service = new OrderWebServiceImplService();
		OrderWebServiceI myWebService = service.getOrderWebServiceImplPort();
		System.out.println(myWebService.sayHello("hxp"));
	}
}
