package socketExample;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClientSample {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 10001);
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			String outputMessage = "test - receive success";
			os.write(outputMessage.getBytes());
			os.flush();
			
			byte[] inputData = new byte[100];
			int length = is.read(inputData);
			String inputMessage = new String(inputData,0,length);
			System.out.println(inputMessage);
			System.out.println("[서버] 종료");
		} catch (IOException e) {
			System.out.println("Failed : " + e);
		}

	}

}
