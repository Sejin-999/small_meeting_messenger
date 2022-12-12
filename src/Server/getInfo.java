package Server;

import java.sql.SQLException;

public class getInfo {
	
	public getInfo() {
		
	}
	
	public boolean getLogin(String getId , String getPass) {
		String setId = getId;
		String setPass = getPass;
		
		boolean userCh;
		
		DBcon con = new DBcon();
		userCh = con.isUser(setId, setPass);
		
		if(userCh == true) {
			System.out.println("DB.. 확인결과 .. 사용자 확인");
			return true;
		}
		else if(userCh == false) {
			System.out.println("DB.. 확인결과 .. 사용자 없음");
			return false;
		}
		else {
			System.out.println("DB.. 확인결과 .. 클래스간 오류.. 관리자 확인필요");
			return false;
		}
	
	}
	
	
	public boolean getRegister(int getSTID , String getID , String getPass , String getNick) {
		int setSTID ;
		String setID,setPass, setNick;
		
		setSTID = getSTID ;
		setID=getID; setPass = getPass; setNick=getNick;
		
		boolean legcheck ; //트루 : 학번값이 없음  , 페일즈 : 학번값이 존재함 
		boolean legcom ; //트루 : 회원가입성공  , 페일즈 : 회원가입실패 
		
		DBcon con = new DBcon();
		try {
			legcheck=con.isRegisterCheck(getSTID);
			if(legcheck == true) {
				legcom = con.isRegister(setSTID,setID, setPass, setNick);
				
				if(legcom = true) {
					System.out.println("서버 종점 : 회원가입 완료");
					return true ; //회원가입성공
				}
				else {
					return false ; //회원가입성공
				}
				
			}
			else {
				System.out.println("학번이 이미 존재한다.");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return false;
	}
	
	/* 완료하면 나중에 이거 IP랑 Nick이랑 합쳐서 하나의 함수에서 한번에 가져올 수 있게 리펙토링 할것*/
	public String giveIp() {
		String ip;  //못받아온경우
		String error = "error";  //커넥션간의 문제가 있는경우
		
		DBcon_Server dbServ = new DBcon_Server();
		
		ip = dbServ.isIp();
		
		if(ip != null) {
			return ip;
		}
		else {
			System.out.println("Ip 값 가져오는데 문제가 발생하였습니다.");
		}
		
		return error;
		
	}
	
	
	public String giveNick(String getId) {
		String nick ;
		String error = "Nick error";
		System.out.println("닉네임 db가져오기 : " +getId );
		DBcon con = new DBcon();
		nick = con.isNick(getId);
		
		if(nick != null) {
			return nick;
		}
		else {
			System.out.println("nickName 값 가져오는데 문제가 발생하였습니다.");
		}
		
		return error;
	}
	
	public int giveSTID(String getId) {
		int setSTID;
	
		DBcon con = new DBcon();
		setSTID = con.isSTID(getId);
		
		if(setSTID != 0) {
			return setSTID;
		}
		
		return 0;
	}
	
	
	
}


