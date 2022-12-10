package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Server.getInfo;


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
				RegBTN= new JButton("회원가입");
				RegBTN.setBounds(300,450,200,40);
				add(RegBTN);
					//회원가입 클래스로 이동 ... Start
					
					//회원가입 클래스로 이동 ... end
				
				
				// 회원가입 회원가입 버튼 ... end
				
				// 회원가입 로그인 버튼 ... Start
				 LogBTN =new JButton("돌아가기");
				 LogBTN.setBounds(300,550,200,40);
				 add(LogBTN);
				// 회원가입 회원가입 버튼 ... end
				
				
				
				setVisible(true);
				
				/* 포커스 이벤트 시작 */
				
				// 포커스 기본설정... Start
				if (idField.getText().length() == 0 ) {
					idField.setText("아아디를 입력하세요");
					idField.setForeground(new Color(150,150,150));
				}
				if (passField .getText().length() == 0 ) {
					passField .setText("비밀번호를 입력하세요");
					passField .setForeground(new Color(150,150,150));
				}
				if (nickNameField.getText().length() == 0 ) {
					nickNameField.setText("닉네임을 입력하세요");
					nickNameField.setForeground(new Color(150,150,150));
				}
				if ( StudentIDField.getText().length() == 0 ) {
					 StudentIDField.setText("학번을 입력하세요");
					 StudentIDField.setForeground(new Color(150,150,150));
				}
				// 포커스 기본설정 ... end				
				
				
				// id 포커스 이벤트 Start
				idField.addFocusListener(new FocusListener() {
					
					@Override
					public void focusLost(FocusEvent e) {
						// TODO Auto-generated method stub
						if (idField.getText().length() == 0 ) {
							idField.setText("아아디를 입력하세요");
							idField.setForeground(new Color(255,26,26));
						}
					}
					
					@Override
					public void focusGained(FocusEvent e) {
						// TODO Auto-generated method stub
						idField.setText(""); 
						idField.setForeground(new Color(50,50,50));
					}
				});
				// id 포커스 이벤트 end
				
				// pass 포커스 이벤트 Start
				passField.addFocusListener(new FocusListener() {
					
					@Override
					public void focusLost(FocusEvent e) {
						// TODO Auto-generated method stub
						if (passField.getText().length() == 0 ) {
							passField.setText("비밀번호를 입력하세요");
							passField.setForeground(new Color(255,26,26));
						}
					}
					
					@Override
					public void focusGained(FocusEvent e) {
						// TODO Auto-generated method stub
						passField.setText(""); 
						passField.setForeground(new Color(50,50,50));
						
					}
				});
				// pass 포커스 이벤트 end

				// nick 포커스 이벤트 Start
				nickNameField.addFocusListener(new FocusListener() {
					
					@Override
					public void focusLost(FocusEvent e) {
						// TODO Auto-generated method stub
						if (nickNameField.getText().length() == 0 ) {
							nickNameField.setText("닉네임을 입력하세요");
							nickNameField.setForeground(new Color(255,26,26));
						}
					}
					
					@Override
					public void focusGained(FocusEvent e) {
						// TODO Auto-generated method stub
						nickNameField.setText(""); 
						nickNameField.setForeground(new Color(50,50,50));
						
					}
				});
				// nick 포커스 이벤트 end

				// stid 포커스 이벤트 Start
				StudentIDField.addFocusListener(new FocusListener() {
					
					@Override
					public void focusLost(FocusEvent e) {
						// TODO Auto-generated method stub
						if (StudentIDField.getText().length() == 0 ) {
							StudentIDField.setText("학번을 입력하세요");
							StudentIDField.setForeground(new Color(255,26,26));
						}
					}
					
					@Override
					public void focusGained(FocusEvent e) {
						// TODO Auto-generated method stub
						StudentIDField.setText(""); 
						StudentIDField.setForeground(new Color(50,50,50));
					}
				});
				// stid 포커스 이벤트 end
					
				/* 포커스 이벤트 종료 */
				
				
				/*핸들러 이벤트 시작*/
				//돌아가기 start
				LogBTN.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						section_login sl = new section_login();
						sl.getContentPane().setBackground(Color.white);
						dispose(); 
					}
				});
				//돌아가기 end
				
				// 회원가입 핸들러 시작
				RegBTN.addActionListener(new ActionListener() {
					
					int boola = 0;
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						//id
						if((idField.getText().equals("아아디를 입력하세요")) || ((idField.getText().length()<2) ||(idField.getText().length()>8) ) ) {
							System.out.println("에러"); // 갯수 확인앞쪽이 의미가없을지도ㅓ..
						}
						else {
							System.out.println("성공");
							 boola++;
						}
						//pass
						if((passField.getText().equals("비밀번호를 입력하세요")) || ((passField.getText().length()<6) ||(passField.getText().length()>10) ) ) {
							System.out.println("비번에러");
						}
						else {
							System.out.println("비번성공");
							 boola++;
						}
						//nick
						if((nickNameField.getText().equals("닉네임을 입력하세요")) || ((nickNameField.getText().length()<1) ||(nickNameField.getText().length()>6) ) ) {
							System.out.println("에러"); // 여기 1보다 작은수 찾는건 의미없음 나중에 수정할것..
						}
						else {
							System.out.println("성공");
							 boola++;
						}
						//stid   
						if((StudentIDField.getText().length() != 10) ) {
							System.out.println("에러");
						}
						else {
							System.out.println("성공");
							 boola++;
						}
						
						
						System.out.println(boola);
						
						if(boola ==4) {
							JOptionPane.showMessageDialog(null, "회원가입에 성공하였습니다!! ");
							//회원가입 메소드로 이동...
							String setId = idField.getText();
							String setPass = passField.getText();
							String setNick = nickNameField.getText();
							String setStID = StudentIDField.getText();
							int chSetStId = Integer.parseInt(setStID);
							
							getInfo gIFo = new getInfo();
							gIFo.getRegister(chSetStId, setId,setPass, setNick);
							//회원가입 메소드로 이동... 종료
							section_login sl = new section_login();
							sl.getContentPane().setBackground(Color.white);
							dispose(); 
						}
						
						
						boola =0;
						
						
						
						
					}
				});
				// 회원가입 핸들러 종료
				/*핸들러 이벤트 시작*/
		
	}
	
	// 로그인 패널 설정
		class RegisterPanel extends JPanel{
			public void paint(Graphics s) {
				s.drawImage(logoImg ,0 ,0 , null);
			}
		}
	
	
}
