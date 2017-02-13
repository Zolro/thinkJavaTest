package com.jw.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.InterfaceAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class OrigClient {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		InetAddress inet=InetAddress.getLocalHost(); 	
		try {
			Socket clien=new Socket(inet.getHostAddress(),8899);
			
			OutputStream os=clien.getOutputStream();
			
			InputStream is=clien.getInputStream();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
