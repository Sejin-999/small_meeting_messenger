package Server;

public class getInfo {
	
	public getInfo() {
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getInfo in = new getInfo();
		System.out.println("서버 시작");
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
	
}


