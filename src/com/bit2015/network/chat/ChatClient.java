package com.bit2015.network.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = null;
		Socket socket = null;
				
		try {
		   //1. Ű���� ����
			
			
			
		   //2. socket ����
		   Socket socket1 = new Socket();
		   
			
			
		   //3. ����
		   //4. reader/ writer ����
		   BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( socket1.getInputStream() ) );
		   PrintWriter printWriter = new PrintWriter( socket1.getOutputStream() );
		   //5. join ��������
		   System.out.print("�г���>>" );
		   String nickname = scanner.nextLine();
		   printWriter.println( "join:" + nickname );
		   printWriter.flush();
		   
		   //6. ChatClientRecevieThread ����
		   Thread thread = new ChatServerProcessThread();
		   thread.start();
		   
		   //7. Ű���� �Է� ó��
		   while( true ) {
		      System.out.print( ">>" );
		      String input = scanner.nextLine();
						
		      if( "quit".equals( input ) == true ) {
		          // 8. quit �������� ó��
		          break;
		      } else {
		          // 9. �޽��� ó��      
		      }
		   }
		   //10. �ڿ�����
		   bufferedReader.close();
		   printWriter.close();
		   if( socket1.isClosed() == false ) {
		       socket1.close();
		   }
		} catch( IOException ex ) {
		       log( "error:" + ex );
		}

		
		
		
		System.out.println("[]");
	

	}

}

public static log(){

	
}

}
