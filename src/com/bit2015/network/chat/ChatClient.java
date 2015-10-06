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
		   //1. 키보드 연결
			
			
			
		   //2. socket 생성
		   Socket socket1 = new Socket();
		   
			
			
		   //3. 연결
		   //4. reader/ writer 생성
		   BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( socket1.getInputStream() ) );
		   PrintWriter printWriter = new PrintWriter( socket1.getOutputStream() );
		   //5. join 프로토콜
		   System.out.print("닉네임>>" );
		   String nickname = scanner.nextLine();
		   printWriter.println( "join:" + nickname );
		   printWriter.flush();
		   
		   //6. ChatClientRecevieThread 시작
		   Thread thread = new ChatServerProcessThread();
		   thread.start();
		   
		   //7. 키보드 입력 처리
		   while( true ) {
		      System.out.print( ">>" );
		      String input = scanner.nextLine();
						
		      if( "quit".equals( input ) == true ) {
		          // 8. quit 프로토콜 처리
		          break;
		      } else {
		          // 9. 메시지 처리      
		      }
		   }
		   //10. 자원정리
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
