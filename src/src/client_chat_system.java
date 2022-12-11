package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.*;

public class client_chat_system {
	Socket sock_client =null;
	String setIP;
	final int port = 9999; //
	
	/*바꿀내용 start*/
	BufferedReader reader;
	InputStream is;  // 바꿀것
	ObjectInputStream ois; //바꿀것
	OutputStream os; //바꿀것
	ObjectOutputStream oos; //바꿀것
	
	String sendData; // 보낼 데이터
	String rivData;  // 받을 데이터
	
	public client_chat_system(String ip) throws UnknownHostException, IOException {
		setIP = ip;
		
		System.out.println("클라이언트 시작");
		
		sock_client = new Socket(ip,port);
		reader = new BufferedReader(new InputStreamReader(System.in));
		
		os =sock_client.getOutputStream();
		oos = new ObjectOutputStream(os);
		is = sock_client.getInputStream();
		ois = new ObjectInputStream(is);
		
		System.out.println("입력 :: ");
		
		while((sendData = reader.readLine()) != null) {
			oos.writeObject(sendData);
			oos.flush();
			if(sendData.equals("quit")) break;
			
			try {
				rivData = (String)ois.readObject();
				System.out.println("abc :"+"받은메시지 :: " + rivData);
				System.out.println("입력 :: ");
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(0);
			}
			
			
		}
		
	}
	
	
	
	
	
	/*바꿀내용 End*/
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		new client_chat_system("127.0.0.1"); //나중에 값받기
	}

}
