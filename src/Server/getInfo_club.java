package Server;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class getInfo_club {
	
	public getInfo_club () {
		
	}
	
	public boolean makeClub(String getClubName ,String getContent , int getAssigned_port , int getClubHead) {
		
		String setClubName , setContent ;
		int setAssigned_port ,setClubHead;
		
		setClubName = getClubName;  setContent = getContent; setAssigned_port = getAssigned_port ;
		setClubHead = getClubHead;
		
		boolean saveSucClub; //true 클럽생성성공 ,, false 인경우 클럽생성실패
		
		DBcon con = new DBcon();
		saveSucClub =con.isMakeClub(getClubName, getContent, getAssigned_port, getClubHead);
		
		if(saveSucClub == true) {
			System.out.println("클럽생성 성공... 최종");
		}
		
		  
		return false; //클럽생성실패
	}
	
	
	public int getPort () {
		int resPort;
		
		DBcon_Server dbSer = new DBcon_Server();
		resPort = dbSer.isPort();
		
		if(resPort != 0) {
			return resPort;
		}
		
		return 0; //0일경우 오류
	}
	
	public boolean updatePort(int getUpdatePort) throws SQLException {
		boolean resUpdatePort;
		
		DBcon_Server dbSer = new DBcon_Server();
		
		resUpdatePort = dbSer.isUpdatePort(getUpdatePort);
		
		if(resUpdatePort == true) {
			//업데이트 성공
			return true;
		}
		
		return false;
	}
	
	
	
}
