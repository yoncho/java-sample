package socketExample;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerSample {

	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket();
			
			serverSocket.bind(new InetSocketAddress("localhost", 10001));
			System.out.println( "[서버] 연결 기다림");

			Socket socket = serverSocket.accept();
			System.out.println( "[서버] 연결됨");

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			byte[] buffer = new byte[512];
			int inputLength = is.read(buffer);
			String inputMessage = new String(buffer, 0, inputLength);
			System.out.println("전달받은 메시지 : " + inputMessage);
			
			String outputMessage = "test - receive success by server";
			os.write(outputMessage.getBytes());
			os.flush();
			socket.close();  
			serverSocket.close();
			System.out.println("[서버] 종료");
		} catch (IOException e) {
			System.out.println("Failed : " + e);
		}
		
		
		
	}

}
