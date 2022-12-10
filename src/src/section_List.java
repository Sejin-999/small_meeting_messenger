package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import src.section_login.LoginPanel;

public class section_List extends JFrame{
	BufferedImage logoImg = null;
	JLabel title;
	
	private JPanel listPanel;
	private JTable listTable;
	private JTextField meet_name;
	private JTextField meet_num;
	private JTextField meet_content;
	private JTextField meet_date;
	private Vector data , header;
	Font font2 = new Font("맑은 고딕", Font.PLAIN,35);
	
	public section_List() {
		setTitle("한국공학대 - 소모임 - 리스트");
		setSize(1000,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		try {
			logoImg = ImageIO.read(new File("C:\\Users\\SeJin\\eclipse-workspace\\small_meeting_messenger\\src\\img\\logo.png")); 
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("이미지 실패.. 파일깨짐");
			System.exit(0);
		}
		
		LogoPanel lp = new LogoPanel();
		lp.setBounds(0,20,600,400);
		
		add(lp);
		
		title = new JLabel("소모임-리스트");
		title.setFont(font2);
		title.setBounds(400,0,600,200);
		add(title);
		
		listPanel = new JPanel();
		listPanel.setBounds(0,200,1000,800);
		add(listPanel);
		
		
		setVisible(true);
		
	}
	
	class LogoPanel extends JPanel{
		public void paint(Graphics s) {
			s.drawImage(logoImg ,0 ,0 , null);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		section_List sl = new  section_List();
		sl.getContentPane().setBackground(Color.white);
	}
	
}
