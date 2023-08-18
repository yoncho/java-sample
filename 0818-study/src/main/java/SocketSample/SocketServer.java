package SocketSample;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SocketServer {
	public static final String IP_ADRESS = "0.0.0.0";
	public static final int PORT = 8881;
	private static int backLog = 10;
	public static Map<Long, String> clientList = new HashMap<Long, String>();
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(IP_ADRESS, PORT), backLog);
			System.out.println("Server Bind Ok");
			while(true) {
				Socket socket = serverSocket.accept(); //Blocking
				System.out.println("Server Accept");
				new ServerRequestHandler(socket).start();
			}
		}catch(Exception e) {
			
		}finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed())
				{
					serverSocket.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
