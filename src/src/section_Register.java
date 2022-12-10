package src;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class section_Register extends JFrame{
	BufferedImage logoImg = null;
	JTextField idField , nickNameField , StudentIDField;
	JTextField passField;
	JButton RegBTN , LogBTN ;
		
	public section_Register() {
		setTitle("한국공학대 - 소모임 - 메신저 - 회원가입");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		// 배경화면 설정
				try {
					logoImg = ImageIO.read(new File("C:\\Users\\SeJin\\eclipse-workspace\\small_meeting_messenger\\src\\img\\logo.png")); 
					
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println("이미지 실패.. 파일깨짐");
					System.exit(0);
				}
				
				// 회원기입 로고 설정 메인 가운데 ...  Start
				RegisterPanel rp = new RegisterPanel();
				rp.setBounds(240,0,800,600);
				
				add(rp);
				// 회원가입  로고 설정 메인 가운데 ...  End
				
				// 회원가입 아아디 인풋 박스 ...  Start
				idField = new JTextField(15);
				idField.setBounds(300,180,200,40);   // 300 가로 , 150 ,세로  200 인풋창 길이 , 40 인풋창 높이
				add(idField);
				// 로그인 아아디 인풋 박스 ...  End
				
				// 회원가입  비밀번호 인풋 박스 ...  Start
				
				passField = new JTextField(15);
				
				passField.setBounds(300,250,200,40);
				add(passField);
				
				// 회원가입  비밀번호 인풋 박스 ...  end
				
				// 회원가입  닉네임 인풋 박스 ... Start
				
				nickNameField = new JTextField(15);
				
				nickNameField.setBounds(300,320,200,40);
				add(nickNameField);
				
				// 회원가입  닉네임 인풋 박스 ... end
				
				// 회원가입 학번 인풋 박스 ... Start
				
				 StudentIDField = new JTextField(15);
				
				 StudentIDField.setBounds(300,390,200,40);
				add( StudentIDField);
				
				// 회원가입  닉네임 인풋 박스 ... end
				
				
				// 회원가입 회원가입 버튼 ... Start
				RegBTN= new JButton();
					//회원가입 클래스로 이동 ... Start
					
					//회원가입 클래스로 이동 ... end
				
				
				// 회원가입 회원가입 버튼 ... end
				
				// 회원가입 로그인 버튼 ... Start
				 LogBTN =new JButton();
				
				// 회원가입 회원가입 버튼 ... end
				
				
				
				setVisible(true);
				
				
				
		
	}
	
	// 로그인 패널 설정
		class RegisterPanel extends JPanel{
			public void paint(Graphics s) {
				s.drawImage(logoImg ,0 ,0 , null);
			}
		}
	
	
}
