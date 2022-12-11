package src;

import java.io.IOException;
import java.net.UnknownHostException;

public class chat_Connect {
	String setIp;
	String setNick;
	
	chat_Connect(String getIp , String getNick) throws UnknownHostException, IOException{
		setIp = getIp;
		setNick = getNick;
		
		new client_chat_system(setIp ,setNick);
		
		
	}
	
}
