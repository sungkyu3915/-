package com.bit2015.network.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private static final int PORT = 50000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ServerSocket serverSocket = null;
		List<PrintWriter> listPrintWriters = new ArrayList<PrintWriter>();
		try{
			
		//�������ϻ���
			serverSocket = new ServerSocket();
		//2. binding
			InetAddress inetAddress = InetAddress.getLocalHost();
			String hostAddress = inetAddress.getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
			log("�����ٸ�"+ hostAddress + ":" + PORT);
			
		//3. �����û ��ٸ�
			while(true){
			Socket socket = serverSocket.accept();
			
			Thread thread = new ChatServerProcessThread(socket, listPrintWriters);
			thread.start();
			}
		}catch(IOException ex){
			log("error:" + ex);
		}finally { 
			if ( serverSocket != null && serverSocket.isClosed() == false){
				try{
					serverSocket.close();
				}catch(IOException ex){
					log ("error:" + ex);
				}
			}
		}

	}
	
	public static void log(String log){
		System.out.println("[char-server]" + log);
	}

}
