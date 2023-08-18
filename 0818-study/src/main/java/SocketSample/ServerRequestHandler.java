package SocketSample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ServerRequestHandler extends Thread {
	private Socket socket = null;
	private String hostName = null;
	private Long currentID;
	
	public ServerRequestHandler(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			//Host Info
			InetSocketAddress iSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			String hostAddress = iSocketAddress.getAddress().getHostAddress();
			
		 	currentID = Thread.currentThread().getId();
		 	
			//IO
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			
			while(true) {
				String data = br.readLine();
				
				if(data == null || "exit".equals(data)) {
					log("closed by client");
					break;
				}
				if (data.contains("INIT ")) {
					System.out.println("Profile Init");
					String userName = data.split(" ")[1];
					System.out.println("PKI : "+ Thread.currentThread().getId() +"\nUserName : " + userName);
					SaveProfile(currentID, userName);
					continue;
				}

				log("received : " + data);
				pw.println(data);
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public synchronized void SaveProfile(Long currentID, String userName) {
		SocketServer.clientList.put(currentID, userName);
	}
	
	public void log(String message)
	{
		System.out.println("[" + SocketServer.clientList.get(currentID).toString() + "| ID: "+ Thread.currentThread().getId() +"] " + message);
	}
}
