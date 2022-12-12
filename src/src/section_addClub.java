package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Server.getInfo_club;

public class section_addClub extends JFrame{
	BufferedImage logoImg = null;
	JTextField clubNameField , contentField;
	JLabel content_s,content_s_title,content_s_stid,content_s_port , studentID , port;
	JButton addClubBTN ;
	int setStudentId; //못받아온 경우 해당값으로
	int setPort;
	String showStudentId , showProt;
	//club_head , Createdate 받아서
	
	public section_addClub(int getStudentId){
		setTitle("한국공학대 - 소모임 - 메신저 - 회원가입");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		setStudentId = getStudentId;
		showStudentId = Integer.toString(setStudentId);
		
		/*여기서 포트번호 가져옴*/
		getInfo_club gIfo_c = new getInfo_club();
		setPort = gIfo_c.getPort();
		setPort +=1; // 다음 포트를 사용할 수 있게... 즉 채팅방이 포트가 달라지며 분리가 생김
		showProt = Integer.toString(setPort);
		
		
		// 배경화면 설정
		try {
			logoImg = ImageIO.read(new File("C:\\Users\\SeJin\\eclipse-workspace\\small_meeting_messenger\\src\\img\\logo.png")); 
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("이미지 실패.. 파일깨짐");
			System.exit(0);
		}
		
		// 클럽추가 로고 설정 메인 가운데 ...  Start
		addClubPanel cp = new addClubPanel();
		cp.setBounds(240,0,800,600);
		
		add(cp);
		// 클럽추가  로고 설정 메인 가운데 ...  End
		
		content_s_title = new JLabel("클럽 이름을 입력하세요 (10글자 내외)");
		content_s_title.setBounds(300,160,300,40); 
		add(content_s_title);
		
		clubNameField = new JTextField(15);
		clubNameField.setBounds(300,200,200,40); 
		add(clubNameField);
		
		content_s = new JLabel("소모임을 설명해주세요 (50글자 내외)");
		content_s.setBounds(300,280,300,40);
		
		add(content_s);
		contentField = new JTextField(50);
		contentField.setBounds(300,330,200,100);
		add(contentField);
		/*학번 Start*/
		content_s_stid = new JLabel("회장 학번 : ");
		content_s_stid.setBounds(300,430,200,100);
		add(content_s_stid);
		
		studentID = new JLabel(showStudentId);
		studentID.setBounds(370,430,200,100);
		add(studentID);
		/*학번 end*/
		
		/*포트 Start*/
		content_s_port = new JLabel("할당된 포트 : ");
		content_s_port.setBounds(300,450,200,100);
		add(content_s_port);
		
		port = new JLabel(showProt);
		port.setBounds(375,450,200,100);
		add(port);
		/*포트 end*/
		
		
		
		setVisible(true);
	}
	
	class addClubPanel extends JPanel{
		public void paint(Graphics s) {
			s.drawImage(logoImg ,0 ,0 , null);
	}
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		section_addClub sl = new  section_addClub(1234567890);
		sl.getContentPane().setBackground(Color.white);
	}

}