package com.mark.demo.axis2.server;

import org.springframework.stereotype.Component;

/*
*hxp(huang.xp@topcheer.com)
*2017Äê9ÔÂ1ÈÕ
*
*/
@Component
public class HelloWorldImpl implements HelloWorld {

	public String sayHello(String name) {
		System.out.println("hi "+name);
		return "hi "+name;
	}

}
