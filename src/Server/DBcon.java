package Server;

import java.sql.*;
import java.sql.DriverManager;

public class DBcon {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	public DBcon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/small_meeting_msg_user","root","1234");
			st =con.createStatement();
		}
		catch(Exception e) {
			System.out.println("DB 커넥션 오류");
		}
	}
	
	public boolean isUser(String userID, String userPassword) {
		//로그인 기능
		String SQL = "SELECT User_PassWord FROM USER_TABLE WHERE User_Id =?";
		try {
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//System.out.println(rs.getString(1));
				if(rs.getString(1).equals(userPassword)) {
					return true;
				}else {
					return false;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("값을 못받음 확인 필요.?");
		}
		return false;
	}
	
	public boolean isRegister(int getSTID , String getID , String getPass , String getNick) {
		try {
			
			//회원가입전 학번확인을 통해 고유성 유지
			int setSTId = getSTID ;
			System.out.println(setSTId);
			String getSTIDSQL = " select exists (select student_id from user_table where student_id = ?)";
			pstmt = con.prepareStatement(getSTIDSQL);
			pstmt.setInt(1,setSTId);
			rs =pstmt.executeQuery();
			
			
			
			if(rs.next()) {
				System.out.println(rs.getInt(1));
				if(rs.getInt(1) == 1) {
					//학생아이디가 이미 있는 경우
					return false;
				}
				else if(rs.getInt(1) == 0) {
					//학생아이디가 없는경우
					System.out.println("회원가입 시작..");
				}
			}
			
			else {
				System.out.println("알 수 없는경우");
				return false;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("회원가입 오류");
		}
		return false;
	}
	
	
	
}
