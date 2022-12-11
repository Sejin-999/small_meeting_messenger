package Server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class server_chat {
	
	public static void main(String[] args) throws IOException {
		new server_chat();
	}
	
	
	ServerSocket serverSock; //대기중인 서버소캣
	final int port = 9999;  //포트 9999
	Socket sock; // 보내기용 소캣
	
	public server_chat() throws IOException {
		serverSock = new ServerSocket(port);
		
		while(true) {
			try {
				System.out.println("소캣 어셉트 시작..");
				sock = serverSock.accept();
				makeThread newThread = new makeThread(sock);  //아래 만들어둔 인풋 아웃풋을 가지고옴
				Thread thr = new Thread(newThread);  //그리고나서 쓰레드로 안에 넣어 선언함
				thr.start();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}

 }


class makeThread implements Runnable{ //추가될 frame 고려해서
	Socket sock;
	
	InputStream is;  // 바꿀것
	ObjectInputStream ois; //바꿀것
	OutputStream os; //바꿀것
	ObjectOutputStream oos; //바꿀것
	String rivData;  //데이저장
	
	makeThread(Socket getSock){
		System.out.println("쓰레드 생성시작");
		sock = getSock;
		try {
			System.out.println("요청 >"+sock.getInetAddress());
			
			is = sock.getInputStream();
			ois = new ObjectInputStream(is);
			
			os = sock.getOutputStream();
			oos = new ObjectOutputStream(os);
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("에러에러");
		}
		
	}
	
	public void run() {
		System.out.println("런 메소드 시작");
		try {
			rivData = (String)ois.readObject(); //사용자에게 받는 메시지
			System.out.println(rivData);
			oos.writeObject(rivData); // 사용자에게 받은걸 다시 보내는 메시지
			oos.flush(); //나중에 지울것 출력스트림 비우는거 .. 
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}


