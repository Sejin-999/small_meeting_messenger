package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Server.getInfo;


public class section_login extends JFrame {
	BufferedImage logoImg = null;
	JTextField idField;
	JTextField passField;
	JButton logBTN , RegBTN;  //reg= register
	
	public section_login() {
		setTitle("한국공학대 - 소모임 - 메신저");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		// 배경화면 설정
		try {
			logoImg = ImageIO.read(new File("C:\\Users\\SeJin\\eclipse-workspace\\small_meeting_messenger\\src\\img\\logo.png")); 
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("이미지 실패.. 파일깨짐");
			System.exit(0);
		}
		
		
		// 로그인 로고 설정 메인 가운데 ...  Start
		LoginPanel lp = new LoginPanel();
		lp.setBounds(240,0,800,600);
		
		add(lp);
		// 로그인 로고 설정 메인 가운데 ...  End
		
		
		// 로그인 아아디 인풋 박스 ...  Start
		idField = new JTextField(15);
		idField.setBounds(300,180,200,40);   // 300 가로 , 150 ,세로  200 인풋창 길이 , 40 인풋창 높이
		add(idField);
		// 로그인 아아디 인풋 박스 ...  End
		
		// 로그인 비밀번호 인풋 박스 ...  Start
		
		passField = new JTextField(15);
		
		passField.setBounds(300,250,200,40);
		add(passField);
		// 로그인 비밀번호 인풋 박스 ...  end
		
		// 로그인 버튼 Start
		logBTN = new JButton("로그인");
		logBTN.setBounds(300,320,200,40);
		add(logBTN);
		// 로그인 버튼 End
		
		// 회원가입 버튼 Start
		RegBTN = new JButton("회원가입");
		RegBTN.setBounds(300,500,200,40);
		add(RegBTN);
		// 회원가입 버튼 End
		
		
		// id 포커스 애니메이션 Start 
		if (idField.getText().length() == 0 ) {
			idField.setText("아아디를 입력하세요...");
			idField.setForeground(new Color(150,150,150));
		}
		
		idField.addFocusListener(new FocusListener() { //id 박스 포커스시 ... 애니
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (idField.getText().length() == 0 ) {
					idField.setText("아아디를 입력하세요... 2~8");
					idField.setForeground(new Color(150,150,150));
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				idField.setText(""); 
				idField.setForeground(new Color(50,50,50));
			}
		});
		
		// id 포커스 애니메이션 End
		
		// 비밀번호 포커스 애니메이션 Start 
		if (passField.getText().length() == 0 ) {
			passField.setText("비밀번호를 입력하세요... 6~10");
			passField.setForeground(new Color(150,150,150));
		}
		
		passField.addFocusListener(new FocusListener() { //id 박스 포커스시 ... 애니
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (passField.getText().length() == 0 ) {
					passField.setText("아아디를 입력하세요...");
					passField.setForeground(new Color(150,150,150));
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				passField.setText("");
				passField.setForeground(new Color(50,50,50));
			}
		});
		// 비밀번호 포커스 애니메이션 End
		
		
		setVisible(true);
		
		
		// 로그인버튼 애니 Start
		logBTN.addActionListener(new ActionListener() {
			String setId = idField.getText();
			String SetPass = passField.getText();
			boolean loginCheck;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//logic , id,pass null check ,, id ,pass length check ,, 
				if((setId.length()==0) || ( SetPass.length()==0)) {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력하지 않았습니다.");
				}
				else {
					if(idField.getText().length()>=2 && passField.getText().length()<=8) {
						//2보다 크거나같은 , 8보다 작거나같은
						//로그인 커넥션 클래스로 이동...Start
						getInfo gIFo = new getInfo();
						//System.out.println(idField.getText());
						//System.out.println(passField.getText());
						loginCheck =gIFo.getLogin(idField.getText(),passField.getText());
						
						if(loginCheck == true) {
							JOptionPane.showMessageDialog(null, "로그인성공");
							
							section_List SL = new section_List(idField.getText());
							SL.getContentPane().setBackground(Color.white);
							
							//chat_Connect();
							
							
							dispose();
						}
						else if(loginCheck = false) {
							JOptionPane.showMessageDialog(null, "로그인실패.. 아이디 비번확인");
						}
						else {
							JOptionPane.showMessageDialog(null, "알 수 없는 오류 , 관리자에게 연락");
						}
						//로그인 커넥션 클래스로 이동...End
					}
					else {
						JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 잘못 입력하였습니다.");
					}
				}
				
				
			}
		});
		// 로그인버튼 애니 End
		
		// 회원가입버튼 애니 Start
		RegBTN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//회원가입 페이지로 이동 ... Start
				section_Register sr = new section_Register();
				sr.getContentPane().setBackground(Color.white);
				dispose();
				//회원가입 페이지로 이동 ... End
			}
			
		});
		// 회원가입버튼 애니 End
		
		
	}
	
	
	// 로그인 패널 설정
	class LoginPanel extends JPanel{
		public void paint(Graphics s) {
			s.drawImage(logoImg ,0 ,0 , null);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		section_login sl = new section_login();
		sl.getContentPane().setBackground(Color.white);
	}
	
	

}


