

/**
 * HelloWorld.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.6  Built on : Jul 30, 2017 (09:08:31 BST)
 */

    package com.mark.demo.axis2.server;

    /*
     *  HelloWorld java interface
     */

    public interface HelloWorld {
          

        /**
          * Auto generated method signature
          * 
                    * @param sayHello0
                
         */

         
                     public com.mark.demo.axis2.server.SayHelloResponse sayHello(

                        com.mark.demo.axis2.server.SayHello sayHello0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param sayHello0
            
          */
        public void startsayHello(

            com.mark.demo.axis2.server.SayHello sayHello0,

            final com.mark.demo.axis2.server.HelloWorldCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    