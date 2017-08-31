package com.mark.demo;

import javax.jws.WebService;

/*
*hxp(huang.xp@topcheer.com)
*2017年8月31日
*
*/
@WebService(endpointInterface = "com.mark.demo.OrderWebServiceI")
public class OrderWebServiceImpl implements OrderWebServiceI{
 
    @Override
    public String sayHello(String name) {
        System.out.println("WebService sayHello " + name);
        return "Hello " + name + ", nice to meet you.";
    }
 
   

}
