package com.mark.demo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/*
*hxp(huang.xp@topcheer.com)
*2017年8月31日
*
*/
@WebService
public interface OrderWebServiceI {
     
    //使用@WebMethod注解标注WebServiceI接口中的方法
    @WebMethod
    String sayHello(@WebParam(name="name") String name);
    
 
}
