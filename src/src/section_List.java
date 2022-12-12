package src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

import Server.DBcon;
import Server.getInfo;
import src.section_login.LoginPanel;

public class section_List extends JFrame{
	BufferedImage logoImg = null;
	JLabel title;
	
	private JPanel listPanel;
	private JPanel infoPanel;  //닉네임 , 소모임 추가버튼
	private JTextField nick_name;
	private JButton add_club;
	private JScrollPane content_pane;
	
	Font font2 = new Font("맑은 고딕", Font.PLAIN,35);
	
	JList list;
	String header[] = {"순번","이름","설명"};
	String contents[][] = {
			{"1","공부동아리","공부를 하는 모임"},
			{"2","공부동아리","공부를 하는 모임"},
			{"3","공부동아리","공부를 하는 모임"},
			{"4","공부동아리","공부를 하는 모임"}
	};
	
	String nickName="undefined";
	String setId;
	
	public section_List(String getId) {
		setId= getId;
		getInfo ina = new getInfo();
		nickName=ina.giveNick(setId);
		
		//int rowlen = contents.length; 
		//System.out.println(rowlen);
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
		/*로고 패널 Start*/
		LogoPanel lp = new LogoPanel();
		lp.setBounds(0,20,600,400);
		
		add(lp);
		//타이틀
		title = new JLabel("소모임-리스트");
		title.setFont(font2);
		title.setBounds(400,0,600,200);
		add(title);
		
		infoPanel = new JPanel();
		
		nick_name = new JTextField(nickName , 10);
		nick_name.setEditable(false);
		add_club = new JButton("소모임 추가하기");
		
		infoPanel.add(nick_name);
		infoPanel.add(add_club);
		
		infoPanel.setBounds(500,0,600,200);
		infoPanel.setBackground(Color.white);
		add(infoPanel);
		
		/*로고 패널 End*/
		
		/*리스트 패널 Start*/
		listPanel = new JPanel();
		listPanel.setBounds(0,200,1000,800);
		listPanel.setBackground(Color.white);
		add(listPanel);
		JTable table = new JTable(contents,header);
		JScrollPane scroll = new JScrollPane(table);
		listPanel.add(scroll);
		
		setVisible(true);
		
		
		add_club.addActionListener(new ActionListener() {
			//소모임 추가 버튼
			// 넘겨줄값 학번이랑 아이디 ././ 아이디는 여기서 받아왔음
			int setSTID;
		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getInfo ginf = new getInfo();
				System.out.println("학번찾기전 아이디값" + setId);
				setSTID = ginf.giveSTID(setId);
				if(setSTID != 0 ) {
					//성공
					new section_addClub(setSTID ,setId );
					dispose();
				}
			}
		});
		
	}
	
	class LogoPanel extends JPanel{
		public void paint(Graphics s) {
			s.drawImage(logoImg ,0 ,0 , null);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		section_List sl = new  section_List("test");
		sl.getContentPane().setBackground(Color.white);
	}
	
}




/*리스트 만들다 안된것들... 나중에 확인해보고 지우기*/

/*
vec = new Vector();
list = new JList();

for(int i=0; i<str.length; i++) {
	vec.addElement(str[i]);
}
list.setListData(vec);
list.setSelectedIndex(0);

content_pane = new JScrollPane(list);
content_pane.setPreferredSize(new Dimension(1000,280));
//listPanel.add(content_pane);
 * *
 */
/*리스트 패널 End*/

/*테이블 제대로할것*/
/*
Dimension conTableSize = new Dimension(1000,300);
JFrame contentFrame = new JFrame();
contentFrame.setBounds(0,200,1000,800);
contentFrame.setPreferredSize(conTableSize);

String header[] = {"순번","이름","설명","날짜"};
String contents[][] = {
		{"1","공부동아리","공부를 하는 모임","12-12"},
		{"2","공부동아리","공부를 하는 모임","12-12"},
		{"3","공부동아리","공부를 하는 모임","12-12"}
};
JTable table = new JTable(contents,header);
JScrollPane scroll = new JScrollPane(table);
listPanel.add(scroll);
contentFrame.pack();
*/
