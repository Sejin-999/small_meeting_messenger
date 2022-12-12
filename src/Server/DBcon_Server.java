package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBcon_Server {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	
	public DBcon_Server() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/small_meeting_msg_server","root","1234");
			st =con.createStatement();
		}
		catch(Exception e) {
			System.out.println("DB 커넥션 오류");
		}
	}
	
	public String isIp() {
		String setIP = null;
		String SQL = "select ip from ip_table where seq = (select max(seq) from ip_table)"; // 가장 최근에 db에 저장된 ip 값을 가지고온다
		try {
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				setIP = rs.getString(1);
				return setIP;
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("값을 못받음 확인 필요.?");
		}
		return setIP; //만약 문제가 있을경우 null값을 전달함
	}
	
	
	//포트번호 주기 ... 클럽 회원가입시
	
	public int isPort() {
		int setPort;
		String SQL = "select port from port_table where seq = (select max(seq) from port_table )";
		try {
			pstmt = con.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				setPort = rs.getInt(1);
				return setPort;
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;  //0일경우 오류
		
	}
	
	
}
