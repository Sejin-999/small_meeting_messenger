package Server;

import java.sql.*;
import java.sql.DriverManager;

public class DBcon {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
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
	
	
	
}
