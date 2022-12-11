package Server;

import java.sql.*;

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
	
	public boolean isRegisterCheck(int getSTID) throws SQLException {
		try {
			int setSTId = getSTID ;
			//회원가입전 학번확인을 통해 고유성 유지
			
			System.out.println(setSTId);
			String getSTIDSQL = " select exists (select student_id from user_table where student_id = ?)";
			pstmt = con.prepareStatement(getSTIDSQL);
			pstmt.setInt(1,setSTId);
			rs =pstmt.executeQuery();

			while(rs.next()) {
				System.out.println(rs.getInt(1));
				if(rs.getInt(1) == 1) {
					//학생아이디가 이미 있는 경우
					return false;
				}
				else if(rs.getInt(1) == 0) {
					//학생아이디가 없는경우
					return true;
				
				}
			}

		}catch (Exception e) {
			// TODO: handle exception
		
		}
		return false;
	}
	
	
	public boolean isRegister(int getSTId , String getId, String getPass , String getNick) {
		int setSTId = getSTId;
		String setId = getId , setPass= getPass , setNick = getNick;
		try {
				String register = "INSERT INTO user_table values(?,?,?,?)";
				pstmt = con.prepareStatement(register);
				pstmt.setInt(1,setSTId);
				pstmt.setString(2, setId);
				pstmt.setString(3,  setPass);
				pstmt.setString(4, setNick);
				pstmt.execute();
				return true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public String isNick(String getId) {
		// 닉네임을 DB에서 뽑아줄 메소드
		String setNick=null;
		String setId = getId;
		String SQL = "select User_nickname from user_table where user_id = ?"; // db에서 아아디에 해당하는 유저닉네임을 가지고온다.
		
		try {
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,setId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("닉네임 db가져오기 : " + rs.getString(1));
				setNick = rs.getString(1);
				return setNick;
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("값을 못받음 확인 필요.?");
		}
		
		return setNick;
	}
	
	/* *******************************소모임에 대한 커넥터 파트**************************************************** */
	public boolean isMakeClub(String getClubName ,String getContent , Date getDate , int getAssigned_port , int getClubHead) {
		String setClubName , setContent ;
		Date setDate;
		int setAssigned_port ,setClubHead;
		
		setClubName = getClubName;  setContent = getContent; setDate = getDate; setAssigned_port = getAssigned_port ;
		setClubHead = getClubHead;
		
		String SQL = "insert into club_table(club_name , content , createDate , assigned_port,club_head)"
				+ "values(?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,setClubName);
			pstmt.setString(2,setContent);
			pstmt.setDate(3,setDate);
			pstmt.setInt(4,setAssigned_port);
			pstmt.setInt(5,setClubHead);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {  //성공하면 값이 불러질거임
				System.out.println("클럽 만들기 성공"+setClubName);
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}


