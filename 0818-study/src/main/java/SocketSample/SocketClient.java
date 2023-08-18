package SocketSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress("127.0.0.1", 8881));
			
			//IO
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			//Client Profile Setting
			System.out.println("UserName: ");
			String userName = (new Scanner(System.in)).nextLine();
			String initProfile = "INIT " + userName;
			pw.println(initProfile);
			
			scanner = new Scanner(System.in);
			
			while(true)
			{
				System.out.print(">>");
				String line = scanner.nextLine();
				
				if("exit".equals(line)) {
					break;
				}
				
				pw.println(line);
				String data = br.readLine();
				
				if(data == null) {
					break;
				}
				System.out.println("<<" + data);
			}
		}catch(Exception e) {
			System.out.println("Error : " + e);
		}finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
				if(scanner != null)
				{
					scanner.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
