package com.chinasofti.etc.rpc;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

public class ServiceURLUtil {
	
	
	
	
	
	static URLStreamHandlerFactory f = new URLStreamHandlerFactory() {

		@Override
		public URLStreamHandler createURLStreamHandler(String protocol) {
			// TODO Auto-generated method stub
			
			System.out.println(protocol);
			if("rpc".equals(protocol)){
				
				URLStreamHandler handler =new URLStreamHandler() {
					
					@Override
					protected URLConnection openConnection(URL u) throws IOException {
						// TODO Auto-generated method stub
						return new URLConnection(u) {
							
							@Override
							public void connect() throws IOException {
								// TODO Auto-generated method stub
								
							}
						};
					}
				};
				return handler;
			}
			return null ;
		}
	};

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		URL.setURLStreamHandlerFactory(f);
		
		URL url =new URL("rpc://test:test@127.0.0.1/Hello");
		//url.setURLStreamHandlerFactory(f);
		
	//	URL.setURLStreamHandlerFactory(f);
		//URL url1 =new URL("rmi://127.0.0.1:8080/Hello");
		//Naming.b
		System.out.println(url.getPort());
		System.out.println(url.getProtocol());
		System.out.println(url.getQuery());
		System.out.println(url.getPath());
		System.out.println(url.getHost());
		System.out.println(url.getUserInfo());

	}
}
